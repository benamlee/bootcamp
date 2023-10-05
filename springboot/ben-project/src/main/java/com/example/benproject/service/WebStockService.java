package com.example.benproject.service;

import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.dto.web.resp.CompanyProfileAndQuoteDTO;

public interface WebStockService {

    // web service, no database
    CompanyProfileAndQuoteDTO getCompanyProfileAndQuoteDTO(String symbol)
            throws FinnhubException;

}
