package com.example.benproject.model.trade;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidAsk {
    // 模擬交易環境, 有no., 盤, 記錄

    private Queue<Order> orders; // 處理order次序 ?
    // 一條queue過處理買賣，quantity用負數表示?
    // 咁add落去就可以直接計算?
    
    private Queue<Order> buyOrders; // ???
    private Queue<Order> sellOrders; // use PriorityQuere 定係 List , implement Comparable? Comparator?
    // 要show去frontend
    // orders 要自動對買賣盤
    // 如何用price排列?

    private List<TradeRecord> tradeRecord = new LinkedList<>(); // 要落database

    // 有 any new order, 即時配對盤能否成交
    // 如果對到成交，trade record 加落database
    public void trade(){
        this.orders
        // 成交到要係 Trader 的 HashMap 加/改 Integer, 股數

    }

}
