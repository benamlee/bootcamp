package com.example.benproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.Code;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;
import com.example.benproject.model.dto.web.resp.CompanyProfileAndQuoteDTO;
import com.example.benproject.model.mapper.FinnhubMapper;
import com.example.benproject.service.CompanyProfileService;
import com.example.benproject.service.QuoteService;
import com.example.benproject.service.WebStockService;

@Service
public class WebStockServiceImpl implements WebStockService {
   
    @Autowired
    private CompanyProfileService companyProfileService;

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private FinnhubMapper finnhubMapper;

    public CompanyProfileAndQuoteDTO getCompanyProfileAndQuoteDTO(String symbol)
            throws FinnhubException {
        CompanyProfile2DTO profile =
                companyProfileService.getCompanyProfile(symbol);
        QuoteDTO quote = quoteService.getQuote(symbol);
        if (profile == null && quote == null)
            throw new FinnhubException(Code.THIRD_PARTY_SERVER_UNAVAILABLE);
        return finnhubMapper.map(profile, quote);
    }


}
