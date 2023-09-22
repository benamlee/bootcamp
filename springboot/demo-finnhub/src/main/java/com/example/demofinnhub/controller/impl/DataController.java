package com.example.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demofinnhub.controller.DataOperation;
import com.example.demofinnhub.entity.Stock123;
import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.service.FinService;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController implements DataOperation {


  @Autowired
  FinService finService;

  @Override
  public Stock123 save(Stock123 stock123) {
    return finService.save(stock123);
  }

  @Override
  public void deleteById(Long id) {
    finService.deleteById(id);
  }

  @Override
  public List<Stock123> findAll() {
    return finService.findAll();
  }

  @Override
  public void updateById(Long id, Stock123 stock123) {
    finService.update(id, stock123);
  }

  @Override
  public List<Stock123> findByCountry(String country) {
    return finService.findByCountry(country);
  }

//   @Override
//   public StockPrice save(StockPrice stockPrice) {
// return finService.save(stockPrice);

  }


}
