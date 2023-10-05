package com.example.benproject.service;

import java.util.List;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;

public interface CompanyProfileService {
    
      // web service, no database
      CompanyProfile2DTO getCompanyProfile(String symbol) throws FinnhubException;


      // database
      List<CompanyProfile> findAllCompanyProfiles();

}
