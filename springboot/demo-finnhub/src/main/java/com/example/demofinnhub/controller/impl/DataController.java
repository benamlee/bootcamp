package com.example.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demofinnhub.controller.DataOperation;
import com.example.demofinnhub.entity.Stock;
import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.service.CompanyService;
import com.example.demofinnhub.service.StockPriceService;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController implements DataOperation {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private StockPriceService stockPriceService;

    @Override
    public List<Stock> findAll() {
        return companyService.findAll();
    }

    @Override
    public List<Stock> findByCountryAndMarketCap(String country,
            double marketCap) {
        return companyService.findByCountryAndMarketCap(country, marketCap);
    }

    @Override
    public Stock save(Stock stock) {
        return companyService.save(stock);
    }

    @Override
    public void deleteById(Long id) {
        companyService.deleteById(id);
    }

    @Override
    public void updateById(Long id, Stock stock) {
        companyService.updateById(id, stock);
    }

    @Override
    public void updateCompanyNameById(Long id, String companyName) {
        companyService.updateCompanyNameById(id, companyName);
    }

    @Override
    public StockPrice save(Long id, StockPrice stockPrice) {
        return stockPriceService.save(id, stockPrice);
    }

}
