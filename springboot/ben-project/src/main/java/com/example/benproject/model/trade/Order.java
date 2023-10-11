package com.example.benproject.model.trade;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order implements Comparable<Order> {
    // show 出來的盤

    private long traderid;

    private BuySell buySell; // 方向

    private double price; // 出價

    private int quantity; // 股數

    private LocalDateTime time;

    @Override
    public int compareTo(Order o) {
        // order by buysell, price, time
        // bbbbbbssssss
        // 
    }



}
