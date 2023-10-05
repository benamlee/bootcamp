package com.example.benproject.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.entity.Quote;
import com.example.benproject.entity.StockSymbol;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;
import com.example.benproject.model.dto.finnhub.resp.SymbolDTO;
import com.example.benproject.model.dto.web.resp.CompanyProfileAndQuoteDTO;
import com.example.benproject.model.dto.web.resp.CompanyProfileTempDTO;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper;

  // return for web, directly return to service to controller, no use database
  public CompanyProfileAndQuoteDTO map(CompanyProfile2DTO companyProfile2DTO,
      QuoteDTO quoteDTO) {
    return CompanyProfileAndQuoteDTO.builder() //
        .companyProfileTempDTO(
            modelMapper.map(companyProfile2DTO, CompanyProfileTempDTO.class)) //
        .currentPrice(quoteDTO.getCurrentPrice()) //
        .dayHigh(quoteDTO.getDayHigh()) //
        .dayLow(quoteDTO.getDayLow()) //
        .dayOpen(quoteDTO.getDayOpen()) //
        .prevDayClose(quoteDTO.getPrevDayClose()) //
        .build();
  }

  // mapping for database table

  // Symbol
  public StockSymbol map(SymbolDTO symbol) {
    return StockSymbol.builder() //
        .symbol(symbol.getSymbol()) //
        .build();
  }

  // CompanyProfile
  public CompanyProfile map(CompanyProfile2DTO profile) {
    return CompanyProfile.builder() //
        .country(profile.getCountry()) //
        .companyName(profile.getCompanyName()) //
        .logo(profile.getLogo()) //
        .marketCap(profile.getMarketCap()) //
        .currency(profile.getCurrency()) //
        .build();
  }

  // Quote
  public Quote map(QuoteDTO quote) {
    return Quote.builder() //
        .currentPrice(quote.getCurrentPrice()) //
        .dayHigh(quote.getDayHigh()) //
        .dayLow(quote.getDayLow()) //
        .dayOpen(quote.getDayOpen()) //
        .prevDayClose(quote.getPrevDayClose()) //
        .build();
  }


}
