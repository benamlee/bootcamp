package com.example.demofinnhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.example.demofinnhub.model.CompanyProfile;
// import com.example.demofinnhub.model.StockDTO;
import com.example.demofinnhub.model.Stock;
import com.example.demofinnhub.model.StockDTO;

public interface StockOperation {

    // @GetMapping(value = "/stock")
    // StockDTO findStock();

    @GetMapping(value = "/stockprice")
    Stock findStock(String symbol);

    @GetMapping(value = "/companyprofile")
    CompanyProfile findCompanyProfile(String symbol);

    @GetMapping(value = "/stock")
    StockDTO response(String symbol);

    
}
