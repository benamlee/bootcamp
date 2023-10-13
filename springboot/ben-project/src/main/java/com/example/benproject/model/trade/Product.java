package com.example.benproject.model.trade;

import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.Code;
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

    public Order getAsk() throws FinnhubException {
        int idx = -1;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            throw new FinnhubException(Code.MARKET_NOTENOUGH_PRODUCT);
        return this.getBidAsk().getOrders().get(idx);
    }

    public Order getBid() throws FinnhubException {
        int idx = -1;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            throw new FinnhubException(Code.MARKET_NOTENOUGH_PRODUCT);
        return this.getBidAsk().getOrders().get(idx - 1);
    }

    public void removeAsk() throws FinnhubException {
        int idx = -1;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            throw new FinnhubException(Code.MARKET_NOTENOUGH_PRODUCT);
        this.getBidAsk().getOrders().remove(idx);
    }

    public void removeBid() throws FinnhubException {
        int idx = -1;
        for (int i = 0; i < this.getBidAsk().getOrders().size(); i++) {
            if (this.getBidAsk().getOrders().get(i)
                    .getBuySell() == BuySell.SELL) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            throw new FinnhubException(Code.MARKET_NOTENOUGH_PRODUCT);
        this.getBidAsk().getOrders().remove(idx - 1);
    }


}
