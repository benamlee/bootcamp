package com.example.benproject.model.trade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BidAsk {
    // 模擬交易環境, 有no., 盤, 記錄
    // 排隊之後先做交易...
    // private Queue<Order> ord; // 唔排隊先?


    private List<Order> orders = new ArrayList<>(); // 處理order次序 ?
    // 一條queue過處理買賣，quantity用負數表示?
    // 咁add落去就可以直接計算?
    // 要show去frontend
    // orders 要自動對買賣盤
    // 如何用price排列?

    private List<TradeRecord> tradeRecord = new LinkedList<>(); // 要落database

    // 有 any new order, 即時配對盤能否成交
    // 如果對到成交，trade record 加落database


    {
        orders.add(new Order(0, BuySell.BUY, 49.8, 200, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 49.85, 300, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 49.90, 250, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 49.95, 400, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 50, 600, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 50.05, 1000, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 50.10, 90, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 50.15, 200, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 50.20, 160, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 50.25, 100, LocalDateTime.now()));
    }
}
