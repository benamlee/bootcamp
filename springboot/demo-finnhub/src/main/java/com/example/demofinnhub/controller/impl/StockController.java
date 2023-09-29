package com.example.demofinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demofinnhub.controller.StockOperation;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.infra.ApiResponse;
import com.example.demofinnhub.model.dto.web.resp.StockDTO;
import com.example.demofinnhub.service.WebStockService;

@RestController
@RequestMapping("/api/v1")
public class StockController implements StockOperation {

  @Autowired
  private WebStockService webStockService;

  @Override
  public ApiResponse<StockDTO> stockInfo(String symbol) // ""
      throws FinnhubException {
    if (symbol.isBlank())
      throw new IllegalArgumentException("Parameter Symbol is blank");
      
    return ApiResponse.<StockDTO>builder() //
        .ok() //
        .data(webStockService.stockInfo(symbol)) //
        .build();
  }
}
