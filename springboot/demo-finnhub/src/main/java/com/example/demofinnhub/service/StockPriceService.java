package com.example.demofinnhub.service;

import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.model.dto.finnhub.resp.Quote;

public interface StockPriceService {

    Quote getQuote(String symbol) throws FinnhubException;

    StockPrice save(Long id, StockPrice stockprice);

}
