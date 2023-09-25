package com.example.demofinnhub.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.demofinnhub.entity.Stock;
import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.infra.Code;
import com.example.demofinnhub.infra.Protocol;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Quote;
import com.example.demofinnhub.model.mapper.FinnhubMapper;
import com.example.demofinnhub.repository.StockPriceRepository;
import com.example.demofinnhub.repository.StockRepository;
import com.example.demofinnhub.repository.StockSymbolRepository;
import com.example.demofinnhub.service.CompanyService;
import com.example.demofinnhub.service.StockPriceService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private FinnhubMapper finnhubMapper;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  private StockSymbolRepository stockSymbolRepository;

  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;

  @Value(value = "${api.finnhub.endpoints.stock.profile2}")
  private String companyProfile2Endpoint;

  @Override
  public void refresh() throws FinnhubException {
    // getCompanyProfile(String symbol)
    stockSymbolRepository.findAll().stream() //
        .forEach(symbol -> {
          try {
            // Get Compnay Profile 2 (New)
            CompanyProfile newProfile =
                this.getCompanyProfile(symbol.getSymbol());
            // Old Stock
            Optional<Stock> oldStock =
                stockRepository.findByStockSymbol(symbol);
            // Update the stock entity
            if (oldStock.isPresent()) { //
              // id & symbol no change
              Stock stock = oldStock.get();
              stock.setCountry(newProfile.getCountry());
              stock.setLogo(newProfile.getLogo());
              stock.setCompanyName(newProfile.getCompanyName());
              stock.setMarketCap(newProfile.getMarketCap());
              stock.setCurrency(newProfile.getCurrency());
              if (newProfile != null
                  && newProfile.getTicker().equals(symbol.getSymbol())) {
                stock.setStockStatus('A');
              } else {
                stock.setStockStatus('I');
              }
              stockRepository.save(stock);
              System.out.println("completed symbol=" + symbol.getSymbol());

              // Get Stock price and save a new record of price into DB
              Quote quote = stockPriceService.getQuote(symbol.getSymbol());
              StockPrice stockPrice = finnhubMapper.map(quote);
              stockPrice.setStock(stock);
              stockPriceRepository.save(stockPrice);
              System.out.println("completed symbol=" + symbol.getSymbol());
            } else {
              System.out.println(symbol.getSymbol() + " is NOT FOUND.");
            }
          } catch (FinnhubException e) {
            System.out
                .println("RestClientException: Symbol" + symbol.getSymbol());
          }

        });
    // If normal response, findById, put the updated entity to DB
    // If abnormal response, patch Entity status to 'I'

  }

  @Override
  public List<Stock> findAll() {
    // return stockRepository.findAllById2(4L); // Test nativeQuery
    // return stockRepository.findAllById3(4L); // Test JPQL
    return stockRepository.findAll(); // mocked
  }

  @Override
  public List<Stock> findByCountryAndMarketCap(String country,
      double marketCap) {
    return stockRepository
        .findFirst3ByCountryAndMarketCapGreaterThanEqualOrderByIdDesc(country,
            marketCap);
  }

  @Override
  public void updateById(Long id, Stock newStock) {
    Stock stock = stockRepository.findById(id) //
        .orElseThrow(
            () -> new EntityNotFoundException("Entity Stock ID not Found"));
    stock.setCompanyName(newStock.getCompanyName());
    stock.setCountry(newStock.getCountry());
    stock.setIpoDate(newStock.getIpoDate());
    stock.setMarketCap(newStock.getMarketCap());
    stock.setCurrency(newStock.getCurrency());
    stock.setLogo(newStock.getLogo());
    stockRepository.save(stock);
  }

  @Override
  public void updateCompanyNameById(Long id, String companyName) {
    Stock stock = stockRepository.findById(id) //
        .orElseThrow(
            () -> new EntityNotFoundException("Entity Stock ID not Found"));
    stock.setCompanyName(companyName);
    stockRepository.save(stock);
  }

  @Override
  public Stock save(Stock stock) {
    return stockRepository.save(stock); // insert into
  }

  @Override
  public void deleteById(Long id) {
    stockRepository.deleteById(id); // delete from table where id = ?
  }

  @Override
  public void deleteAll() {
    stockRepository.deleteAll();
  }

  @Override
  public CompanyProfile getCompanyProfile(String symbol)
      throws FinnhubException {
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name().toLowerCase()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(companyProfile2Endpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token) //
        .build() // write this, then domain can use "/"
        .toUriString();

    try {
      return restTemplate.getForObject(url, CompanyProfile.class); // mocked
    } catch (RestClientException e) {
      throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
    }

  }



}
