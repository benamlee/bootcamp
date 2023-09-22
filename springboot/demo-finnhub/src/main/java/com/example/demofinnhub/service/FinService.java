package com.example.demofinnhub.service;


import java.util.List;
import com.example.demofinnhub.entity.Stock123;
import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Stock;

public interface FinService {

    public Stock findStock(String symbol);

    public CompanyProfile findProfile(String symbol);

    Stock123 save(Stock123 stock);

    void deleteById(Long id);

    List<Stock123> findAll();

    void update(Long id, Stock123 stock123);

    List<Stock123> findByCountry(String country);

    // StockPrice save(StockPrice stockPrice);

}
