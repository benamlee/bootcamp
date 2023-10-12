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
        orders.add(new Order(0, BuySell.BUY, 46, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 47, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 48, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 49, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.BUY, 50, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 51, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 52, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 53, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 54, 100, LocalDateTime.now()));
        orders.add(new Order(0, BuySell.SELL, 55, 100, LocalDateTime.now()));
    }
}
