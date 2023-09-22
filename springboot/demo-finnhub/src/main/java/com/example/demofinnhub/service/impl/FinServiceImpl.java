package com.example.demofinnhub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.demofinnhub.entity.Stock123;
import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.infra.Protocol;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Stock;
import com.example.demofinnhub.repository.StockPriceRepository;
import com.example.demofinnhub.repository.StockRepository;
import com.example.demofinnhub.service.FinService;
import jakarta.persistence.EntityNotFoundException;


@Service
public class FinServiceImpl implements FinService {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${api.finnhub.domain}")
    private String finnhubDomain;

    @Value(value = "${api.finnhub.endpoint.stock}")
    private String stockPrice;

    @Value(value = "${api.finnhub.endpoint.profile2}")
    private String stockProfile;

    @Autowired
    @Qualifier(value = "finnhubToken")
    private String apiKey;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockPriceRepository stockPriceRepository;

    // @Value(value = "${api.finnhub}")
    // String api;

    @Override
    public Stock findStock(String symbol) {
        String url = UriComponentsBuilder.newInstance() //
                .scheme(Protocol.HTTPS.name()) //
                .host(finnhubDomain) //
                .path(stockPrice) //
                .queryParam("symbol", symbol) //
                .queryParam("token", apiKey) //
                .build() // write this, then domain can use "/"
                .toUriString();

        // url+="?symbol=AAPL&token=ck4flr1r01qus81pv4l0ck4flr1r01qus81pv4lg";
        // url += "?symbol=AAPL&token=ck4flr1r01qus81pv4l0ck4flr1r01qus81pv4lg";

        // String url = api;

        System.out.println("url=" + url);

        // "https://finnhub.io/api/v1/quote?symbol=AAPL&token=ck4flr1r01qus81pv4l0ck4flr1r01qus81pv4lg";
        return restTemplate.getForObject(url, Stock.class);
    }

    @Override
    public CompanyProfile findProfile(String symbol) {
        String url = UriComponentsBuilder.newInstance() //
                .scheme(Protocol.HTTPS.name()) //
                .host(finnhubDomain) //
                .path(stockProfile) //
                .queryParam("symbol", symbol) //
                .queryParam("token", apiKey) //
                .build() // write this, then domain can use "/"
                .toUriString();


        System.out.println("url=" + url);

        return restTemplate.getForObject(url, CompanyProfile.class);
    }


    @Override
    public Stock123 save(Stock123 stock123) {
        return stockRepository.save(stock123);
    }

    @Override
    public void deleteById(Long id) {
        stockRepository.deleteById(id); // delete from table where id = ?
    }

    @Override
    public List<Stock123> findAll() {
        return stockRepository.findAll();
        // return stockRepository.findAllById2(1L); // just a quick try on .findAllById2 method
        // return stockRepository.findAllById3(5L);
    }


    @Override
    public void update(Long id, Stock123 newStock123) {
        // if (!stockRepository.existsById(id))
        // return false;
        // stockRepository.save(stock123);
        // return true;
        Stock123 oldStock123 = stockRepository.findById(id) //
                .orElseThrow(() -> new EntityNotFoundException());
        oldStock123.setCompanyName(newStock123.getCompanyName());
        oldStock123.setCountry(newStock123.getCountry());
        oldStock123.setCurrency(newStock123.getCurrency());
        oldStock123.setIpoDate(newStock123.getIpoDate());
        oldStock123.setLogo(newStock123.getLogo());
        oldStock123.setMarketCap(newStock123.getMarketCap());
        stockRepository.save(oldStock123);
    }

    @Override
    public List<Stock123> findByCountry(String country) {
        return stockRepository.findByCountry(country);
    }

    // @Override
    // public StockPrice save(Long id,StockPrice stockPrice) {
    //     Stock stock = stockRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
    //     stockPrice = stock
    //     return stockPriceRepository.save(stockPrice);
    // }

}
