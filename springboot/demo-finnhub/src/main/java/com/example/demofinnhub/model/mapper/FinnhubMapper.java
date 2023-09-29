package com.example.demofinnhub.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demofinnhub.entity.Stock;
import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.entity.StockSymbol;
import com.example.demofinnhub.model.dto.finnhub.resp.CompanyProfile;
import com.example.demofinnhub.model.dto.finnhub.resp.Quote;
import com.example.demofinnhub.model.dto.finnhub.resp.Symbol;
import com.example.demofinnhub.model.dto.web.resp.CompanyProfileDTO;
import com.example.demofinnhub.model.dto.web.resp.StockDTO;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper; // a bean from AppConfig

  public StockDTO map(CompanyProfile companyProfile, Quote quote) {
    return StockDTO.builder() //
        .companyProfile(
            modelMapper.map(companyProfile, CompanyProfileDTO.class)) // modelMapper:DTO找原頁的instance
        .currentPrice(quote.getCurrentPrice()) //
        .dayHigh(quote.getDayHigh()) //
        .dayLow(quote.getDayLow()) //
        .dayOpen(quote.getDayOpen()) //
        .prevDayClose(quote.getPrevDayClose()) //
        .build();
  }

  public StockSymbol map(Symbol symbol) {
    return StockSymbol.builder() //
        .symbol(symbol.getSymbol()) //
        .build();
  }

  public Stock map(CompanyProfile profile) {
    return Stock.builder() //
        .country(profile.getCountry()) //
        .companyName(profile.getCompanyName()) //
        .logo(profile.getLogo()) //
        .marketCap(profile.getMarketCap()) //
        .currency(profile.getCurrency()) //
        .build();
  }

  public StockPrice map(Quote quote) {
    return StockPrice.builder() //
        .currentPrice(quote.getCurrentPrice()) //
        .dayHigh(quote.getDayHigh()) //
        .dayLow(quote.getDayLow()) //
        .dayOpen(quote.getDayOpen()) //
        .prevDayClose(quote.getPrevDayClose()) //
        .build();
  }
}
