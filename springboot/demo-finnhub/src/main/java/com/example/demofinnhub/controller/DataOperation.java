package com.example.demofinnhub.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demofinnhub.entity.Stock123;
import com.example.demofinnhub.entity.StockPrice;

public interface DataOperation {

  @PostMapping(value = "/data/stock")
  @ResponseStatus(value = HttpStatus.OK)
  Stock123 save(@RequestBody Stock123 stock123);

  @GetMapping(value = "/data/stocks")
  @ResponseStatus(value = HttpStatus.OK)
  List<Stock123> findAll();

  @DeleteMapping(value = "/data/stock/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void deleteById(@PathVariable Long id);


  @PutMapping(value = "/data/stock/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void updateById(@PathVariable Long id, @RequestBody Stock123 stock123); // only id is input

  @PutMapping(value = "/data/stock/{country}")
  @ResponseStatus(value = HttpStatus.OK)
  List<Stock123> findByCountry(@PathVariable String country);

  // @PostMapping("data/stock/price")
  // @ResponseStatus(value = HttpStatus.OK)
  // StockPrice save(@RequestBody StockPrice stockPrice);

}
