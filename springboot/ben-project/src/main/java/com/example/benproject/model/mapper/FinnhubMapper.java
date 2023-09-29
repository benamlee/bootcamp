package com.example.benproject.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;
import com.example.benproject.model.dto.web.resp.CompanyProfileAndQuoteDTO;
import com.example.benproject.model.dto.web.resp.CompanyProfileTempDTO;

@Component
public class FinnhubMapper {
  
    @Autowired
    private ModelMapper modelMapper;

    // return for web, no use database
    public CompanyProfileAndQuoteDTO map(CompanyProfile2DTO companyProfile2DTO, QuoteDTO quoteDTO){
        return CompanyProfileAndQuoteDTO.builder() //
        .companyProfileTempDTO(modelMapper.map(companyProfile2DTO,CompanyProfileTempDTO.class)) //
        .currentPrice(quoteDTO.getCurrentPrice()) //
      .dayHigh(quoteDTO.getDayHigh()) //
      .dayLow(quoteDTO.getDayLow()) //
      .dayOpen(quoteDTO.getDayOpen()) //
      .prevDayClose(quoteDTO.getPrevDayClose()) //
      .build();
    }
}
