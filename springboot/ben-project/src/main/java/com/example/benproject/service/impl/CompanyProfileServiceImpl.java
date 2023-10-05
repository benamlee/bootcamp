package com.example.benproject.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.entity.Quote;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.Code;
import com.example.benproject.infra.Protocol;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;
import com.example.benproject.model.mapper.FinnhubMapper;
import com.example.benproject.repository.CompanyProfileRepository;
import com.example.benproject.repository.QuoteRepository;
import com.example.benproject.repository.StockSymbolRepository;
import com.example.benproject.service.CompanyProfileService;
import com.example.benproject.service.QuoteService;

@Service
// @Slf4j // 可以用「 log.info("url = " + url); 」去print, 同System.out.print()一樣
public class CompanyProfileServiceImpl implements CompanyProfileService {

    // JSON -> java object
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "finnhubToken")
    private String token;
  
    @Value(value = "${api.finnhub.domain}")
    private String domain;
  
    @Value(value = "${api.finnhub.base-url}")
    private String baseUrl;
  
    @Value(value = "${api.finnhub.endpoints.stock.profile2}")
    private String companyProfile2Endpoint;


    // database
    @Autowired
    private CompanyProfileRepository companyProfileRepository;


    // refresh, get data every minute
    @Autowired
    private StockSymbolRepository stockSymbolRepository;
    @Autowired
    private QuoteService quoteService;
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private FinnhubMapper finnhubMapper;

    
    // get json , -> deserialization to java object
    @Override
    public CompanyProfile2DTO getCompanyProfile(String symbol)
            throws FinnhubException {
        String url = UriComponentsBuilder.newInstance() //
                .scheme(Protocol.HTTPS.name().toLowerCase()) //
                .host(domain) //
                .pathSegment(baseUrl) //
                .path(companyProfile2Endpoint) //
                .queryParam("symbol", symbol) //
                .queryParam("token", token) //
                .build() //
                .toUriString();
                
        System.out.println("url=" + url);
        // url="https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=ck5rdg9r01qls0umc6mgck5rdg9r01qls0umc6n0";
        try {
            CompanyProfile2DTO profile =
                    restTemplate.getForObject(url, CompanyProfile2DTO.class);
            return profile;
        } catch (RestClientException e) {
            throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
        }
    }


     // database methods
    @Override
    public List<CompanyProfile> findAllCompanyProfiles(){
        return companyProfileRepository.findAll();
    }


    // refresh, get data every minute
    @Override
    public void refresh() throws FinnhubException {

        // find from symbol table, saved entity
        stockSymbolRepository.findAll().stream() //
        .forEach(symbol -> {
            try{
                // get company profile from api
                CompanyProfile2DTO newProfile = this.getCompanyProfile(symbol.getSymbol());

                // this method have to self write in repository
                Optional<CompanyProfile> oldCompanyProfile = companyProfileRepository.findByStockSymbol(symbol);

                // update the company profile entity
                if (oldCompanyProfile.isPresent()) {
                    // id & symbol no change
                    // suppose no change
                    CompanyProfile companyProfile = oldCompanyProfile.get();
                    companyProfile.setCountry(newProfile.getCountry());
                    companyProfile.setLogo(newProfile.getLogo());
                    companyProfile.setCompanyName(newProfile.getCompanyName());
                    companyProfile.setMarketCap(newProfile.getMarketCap());
                    companyProfile.setCurrency(newProfile.getCurrency());

                    // just in case, finnhub is not working or the company close
                    if (newProfile != null && newProfile.getTicker().equals(symbol.getSymbol())) {
                        companyProfile.setStockStatus('A'); // active
                    } else {
                        companyProfile.setStockStatus('I'); // inactive
                    }
                    companyProfileRepository.save(companyProfile);
                    System.out.println("completed symbol=" + symbol.getSymbol());

                    // get quote and save a new record of price into DB
                    QuoteDTO quoteDTO = quoteService.getQuote(symbol.getSymbol());
                    Quote quote = finnhubMapper.map(quoteDTO);
                    quote.setCompanyProfile(companyProfile);
                    quoteRepository.save(quote);
                    System.out.println("completed symbol=" + symbol.getSymbol());
                } else {
                    System.out.println(symbol.getSymbol() + " is NOT FOUND.");
                }
            } catch (FinnhubException e) {
                System.out.println("RestClientException: Symbol" + symbol.getSymbol());
            }
        });
    }
}
