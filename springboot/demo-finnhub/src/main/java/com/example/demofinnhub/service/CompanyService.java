package com.example.demofinnhub.service;

import java.util.List;
import com.example.demofinnhub.entity.Stock;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.model.CompanyProfile;

public interface CompanyService {

  CompanyProfile getCompanyProfile(String symbol) throws FinnhubException;

  void refresh() throws FinnhubException;

  void updateById(Long id, Stock stock);

  List<Stock> findAll();

  List<Stock> findByCountryAndMarketCap(String country, double marketCap);

  Stock save(Stock stock);

  void deleteById(Long id);

  void deleteAll();

  void updateCompanyNameById(Long id, String companyName);

}
