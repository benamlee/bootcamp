package com.example.benproject.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.benproject.controller.TradeOperation;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.trade.Order;
import com.example.benproject.model.trade.TradeRecord;
import com.example.benproject.service.TradeService;

@RestController
@RequestMapping(value = "/api/v2")
public class TradeController implements TradeOperation {

    @Autowired
    private TradeService tradeService;


    @Override
    public List<Order> findOrders() {
        return tradeService.findOrders();
    }

    @Override
    public void marketOrder(String stockName, String buySell, Integer quantity)
            throws FinnhubException {
        tradeService.marketOrder(stockName, buySell, quantity);
    }

    @Override
    public void limitOrder(String stockName, String buySell, Double price,
            Integer quantity) throws FinnhubException {
        tradeService.limitOrder(stockName, buySell, price, quantity);
    }

    @Override
    public List<TradeRecord> findAll() {
        return tradeService.findAll();
    }

}
