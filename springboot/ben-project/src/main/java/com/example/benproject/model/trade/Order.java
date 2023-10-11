package com.example.benproject.model.trade;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
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
        if (this.buySell == o.buySell) {
            if (o.price != this.price) {
                return o.price < this.price ? 1 : -1;
            } else {
                return o.time.isBefore(this.time) ? 1 : -1;
            }
        }
        if (this.buySell == BuySell.BUY)
            return -1;
        return 1;
    }

  

}
