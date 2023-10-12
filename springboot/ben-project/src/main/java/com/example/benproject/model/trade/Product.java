package com.example.benproject.model.trade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String stockName; //

    private BidAsk bidAsk;

    public Order getAsk() {
        int idx = 0;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        return this.getBidAsk().getOrders().get(idx);
    }

    public Order getBid() {
        int idx = 0;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        return this.getBidAsk().getOrders().get(idx - 1);
    }

    public void removeAsk() {
        int idx = 0;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        this.getBidAsk().getOrders().remove(idx);
    }

    public void removeBid() {
        int idx = 0;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        this.getBidAsk().getOrders().remove(idx - 1);
    }


}
