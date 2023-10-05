package com.example.benproject.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.benproject.controller.DataBaseOperation;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.entity.Quote;
import com.example.benproject.service.CompanyProfileService;
import com.example.benproject.service.QuoteService;


// database
@RestController
@RequestMapping(value = "/api/v1")
public class DataBaseController implements DataBaseOperation {

    @Autowired
    private CompanyProfileService companyProfileService;

    @Autowired
    private QuoteService quoteService;


    @Override
    public List<CompanyProfile> findAllCompanyProfiles() {
        return companyProfileService.findAllCompanyProfiles();
    }

    @Override
    public List<Quote> findAllQuotes() {
        return quoteService.findAllQuotes();
    }

    
}
