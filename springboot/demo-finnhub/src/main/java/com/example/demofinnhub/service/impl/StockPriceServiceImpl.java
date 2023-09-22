package com.example.demofinnhub.service.impl;

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
import com.example.demofinnhub.model.Quote;
import com.example.demofinnhub.repository.StockPriceRepository;
import com.example.demofinnhub.repository.StockRepository;
import com.example.demofinnhub.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;

  @Value(value = "${api.finnhub.endpoints.stock.quote}")
  private String quoteEndpoint;

  @Override
  public Quote getQuote(String symbol) throws FinnhubException {
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(quoteEndpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token) //
        .build() // write this, then domain can use "/"
        .toUriString();
    System.out.println("url=" + url);
    try {
      return restTemplate.getForObject(url, Quote.class);
    } catch (RestClientException e) {
      throw new FinnhubException(Code.FINNHUB_QUOTE_NOTFOUND);
    }
  }

  @Override
  public StockPrice save(Long id, StockPrice stockPrice) {
    Stock stock = stockRepository.findById(id).orElse(null);
    stockPrice.setStock(stock);
    return stockPriceRepository.save(stockPrice);
  }

}
