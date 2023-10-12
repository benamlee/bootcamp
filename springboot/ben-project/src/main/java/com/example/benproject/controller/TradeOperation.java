package com.example.benproject.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.trade.Order;
import com.example.benproject.model.trade.TradeRecord;

public interface TradeOperation {
    

    @GetMapping(value = "/orders")
    List<Order> findOrders();

    @PostMapping(value = "/marketorder")
    void marketOrder(@RequestParam String stockName, @RequestParam String buySell, @RequestParam Integer quantity) throws FinnhubException;

    @PostMapping(value = "/limitorder")
    void limitOrder(@RequestParam String stockName, @RequestParam String buySell, @RequestParam Double price
    , @RequestParam Integer quantity) throws FinnhubException;

    @GetMapping(value = "/traderecord")
    List<TradeRecord> findAll();

}
