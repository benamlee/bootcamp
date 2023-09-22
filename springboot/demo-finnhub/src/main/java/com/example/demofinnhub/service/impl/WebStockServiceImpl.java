package com.example.demofinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.infra.Code;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Quote;
import com.example.demofinnhub.model.dto.StockDTO;
import com.example.demofinnhub.model.mapper.FinnhubMapper;
import com.example.demofinnhub.service.CompanyService;
import com.example.demofinnhub.service.StockPriceService;
import com.example.demofinnhub.service.WebStockService;

@Service
public class WebStockServiceImpl implements WebStockService{

  @Autowired
  private CompanyService companyService;

  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private FinnhubMapper finnhubMapper;

  @Override
  public StockDTO stockInfo(String symbol) throws FinnhubException {
    CompanyProfile profile = companyService.getCompanyProfile(symbol);
    Quote quote = stockPriceService.getQuote(symbol);
    if (profile == null && quote == null)
      throw new FinnhubException(Code.THIRD_PARTY_SERVER_UNAVAILABLE);
    return finnhubMapper.map(profile, quote);
  }

}