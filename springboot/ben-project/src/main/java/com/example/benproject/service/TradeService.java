package com.example.benproject.service;

import java.util.List;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.trade.Order;
import com.example.benproject.model.trade.TradeRecord;

public interface TradeService {

    List<Order> findOrders();

    void marketOrder(String stockName, String buySell, Integer quantity)
            throws FinnhubException;

    void limitOrder(String stockName, String buySell, Double price,
            Integer quantity) throws FinnhubException;

    List<TradeRecord> findAll();
}
