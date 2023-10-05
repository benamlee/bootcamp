package com.example.benproject.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.benproject.entity.StockSymbol;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.Code;
import com.example.benproject.infra.Protocol;
import com.example.benproject.model.dto.finnhub.resp.SymbolDTO;
import com.example.benproject.model.mapper.FinnhubMapper;
import com.example.benproject.repository.StockSymbolRepository;
import com.example.benproject.service.StockSymbolService;

@Service
public class StockSymbolServiceImpl implements StockSymbolService {

    // get from website
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "finnhubToken")
    private String token;

    @Value(value = "${api.finnhub.domain}")
    private String domain;

    @Value(value = "${api.finnhub.base-url}")
    private String baseUrl;

    @Value(value = "${api.finnhub.endpoints.stock.symbol}")
    private String symbolEndpoint;


    // database
    // convert dto to database entity
    @Autowired
    private FinnhubMapper finnhubMapper;

    @Autowired
    private StockSymbolRepository symbolRepository;


    // no database
    @Override
    public List<SymbolDTO> getAllSymbols() throws FinnhubException {
        String url = UriComponentsBuilder.newInstance() //
                .scheme(Protocol.HTTPS.name()) //
                .host(domain) //
                .pathSegment(baseUrl) //
                .path(symbolEndpoint) //
                .queryParam("exchange", "US") //
                .queryParam("token", token) //
                .build() //
                .toUriString();
        System.out.println("url=" + url);
        try {
            SymbolDTO[] symbolDTOs =
                    restTemplate.getForObject(url, SymbolDTO[].class);
            return Arrays.asList(symbolDTOs);
        } catch (RestClientException e) {
            throw new FinnhubException(Code.FINNHUB_SYMBOL_NOTFOUND);
        }
    }


    // database
    @Override
    public List<StockSymbol> save(List<SymbolDTO> symbolDTOs) {
        // convert symbolDTO to stocksymbol entity
        List<StockSymbol> stockSymbols = symbolDTOs.stream() //
                .filter(s -> "Common Stock".equals(s.getType())) //
                .map(s -> finnhubMapper.map(s)) // convert to entity
                .collect(Collectors.toList());
        // Save to DB
        return symbolRepository.saveAll(stockSymbols);
    }

    // @Override
    // public void deleteAll() {
    //     symbolRepository.deleteAll();
    // }

}
