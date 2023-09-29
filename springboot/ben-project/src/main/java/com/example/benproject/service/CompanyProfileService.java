package com.example.benproject.service;

import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;

public interface CompanyProfileService {
    
      CompanyProfile2DTO getCompanyProfile(String symbol) throws FinnhubException;

}
