package com.example.demofinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demofinnhub.controller.StockOperation;
import com.example.demofinnhub.mapper.StockMapper;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Stock;
import com.example.demofinnhub.model.StockDTO;
import com.example.demofinnhub.service.FinService;

@RestController
@RequestMapping("/api/v1")
public class StockController implements StockOperation {

    @Autowired
    FinService finService;

    @Override
    public Stock findStock(String symbol) {
        return finService.findStock(symbol);
    }

    @Override
    public CompanyProfile findCompanyProfile(String symbol) {
        return finService.findProfile(symbol);
    }

    @Override
    public StockDTO response(String symbol){
        return StockMapper.map(findStock(symbol), findCompanyProfile(symbol));
    }
}
