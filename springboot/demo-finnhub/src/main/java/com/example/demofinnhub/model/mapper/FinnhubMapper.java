package com.example.demofinnhub.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Quote;
import com.example.demofinnhub.model.dto.CompanyProfileDTO;
import com.example.demofinnhub.model.dto.StockDTO;

@Component
public class FinnhubMapper {
    
  @Autowired
  private ModelMapper modelMapper;

  public StockDTO map(CompanyProfile companyProfile, Quote quote) {
    return StockDTO.builder() //
      .companyProfile(modelMapper.map(companyProfile, CompanyProfileDTO.class)) //
      .currentPrice(quote.getCurrentPrice()) //
      .dayHigh(quote.getDayHigh()) //
      .dayLow(quote.getDayLow()) //
      .dayOpen(quote.getDayOpen()) //
      .prevDayClose(quote.getPrevDayClose()) //
      .build();
  }
}
