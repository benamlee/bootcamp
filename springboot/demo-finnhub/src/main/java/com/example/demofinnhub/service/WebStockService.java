package com.example.demofinnhub.service;

import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.model.dto.web.resp.StockDTO;

public interface WebStockService {
  
  StockDTO stockInfo(String symbol) throws FinnhubException;

}
