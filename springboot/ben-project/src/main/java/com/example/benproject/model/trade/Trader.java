package com.example.benproject.model.trade;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.Code;

public class Trader {

    // Buyer Seller
    private long id;

    private double money;

    private HashMap<Product, Integer> products; //

    // 可以做：在指定 BidAsk 做 new order 的 method



    // 市價盤

    public void marketOrder(Product product, BuySell buySell, int quantity)
            throws FinnhubException {
        // 未寫check錢
        if (buySell == BuySell.BUY) {
            for (int i = 0; i < product.getBidAsk().getOrders().size() || quantity > 0; i++) {
                // 隊->第一個sell
                if (product.getBidAsk().getOrders().get(i).getBuySell() == BuySell.SELL) {
                    // 第一個就成交哂
                    if (product.getBidAsk().getOrders().get(i).getQuantity() > quantity) {
                        // 隊改quantity
                        product.getBidAsk().getOrders().get(i).setQuantity(product.getBidAsk().getOrders().get(i).getQuantity() - quantity);
                        // 倉加貨
                        // 倉可能係null
                        this.products.put(product, this.products.get(product) == null ? quantity : this.products.get(product) + quantity); 
                        //  ?? tradeRecordRepository.save(new TradeRecord(,,));
                        
                        quantity = 0;
                    } else {
                        quantity -= product.getBidAsk().getOrders().get(i).getQuantity();
                        // 倉加貨
                        // 倉可能係null
                        this.products.put(product, this.products.get(product) == null ? product.getBidAsk().getOrders().get(i).getQuantity() : this.products.get(product) + product.getBidAsk().getOrders().get(i).getQuantity()); 
                        //  ?? tradeRecordRepository.save(new TradeRecord(,,));

                        // 隊remove一個盤，去下一個繼續成交
                        product.getBidAsk().getOrders().remove(i);
                        i--;
                    }
                }
            }

        }

        if (buySell == BuySell.SELL) {
            if (this.products.get(product) < quantity) {
                throw new FinnhubException(Code.TRADER_NOTENOUGH_PRODUCT);
            } else {
                for(int i = 0; i < product.getBidAsk().getOrders().size() || quantity > 0; i++) {
                    if (product.getBidAsk().getOrders().get(i).getBuySell() == BuySell.SELL) {
                        if (product.getBidAsk().getOrders().get(i - 1).getQuantity() > quantity) {
                            product.getBidAsk().getOrders().get(i - 1).setQuantity(product.getBidAsk().getOrders().get(i - 1).getQuantity() - quantity);
                            // map一定有，唔洗check null
                            this.products.put(product, this.products.get(product) - quantity); 
                        } else {
                            quantity -= product.getBidAsk().getOrders().get(i - 1).getQuantity();
                            // map一定有，唔洗check null
                            this.products.put(product, this.products.get(product) - product.getBidAsk().getOrders().get(i - 1).getQuantity());
                            product.getBidAsk().getOrders().remove(i - 1);
                            i--;
                        }
                    }
                }
            }
        }
        // ?? tradeRecordRepository.save(new TradeRecord(,,));
        Collections.sort(product.getBidAsk().getOrders());
    }

    // 限價盤
    public void limitOrder(Product product, BuySell buySell, double price,
            int quantity) throws FinnhubException{

        // check if trader have sufficent product for sell or sufficient money for buy
        if (buySell == BuySell.BUY && this.money < price * quantity)
                throw new FinnhubException(Code.TRADER_NOTENOUGH_MONEY);
        if (buySell == BuySell.SELL && this.products.get(product) == null || this.products.get(product) < quantity)
                throw new FinnhubException(Code.TRADER_NOTENOUGH_PRODUCT);

        // locate the idx of sell;
        int idx = 0;
        for (int i = 0; i < product.getBidAsk().getOrders().size();i++){
            if (product.getBidAsk().getOrders().get(i).getBuySell() == BuySell.SELL){
                idx = i;
            }
        }
 
        if (buySell == BuySell.BUY) {
            // 太低價不成交
            if (price < product.getBidAsk().getOrders().get(idx).getPrice()) {
                // 直接order排隊
                product.getBidAsk().getOrders().add(new Order(this.id, buySell, price, quantity, LocalDateTime.now()));
            } else {
                // 有成交
                // quantity 一邊成交一邊減 , 
                while (quantity > 0 && product.getBidAsk().getOrders().get(idx).getPrice() < price) {
                    // 直接成交哂
                    if (product.getBidAsk().getOrders().get(idx).getQuantity() > quantity) {
                        product.getBidAsk().getOrders().get(idx).setQuantity(product.getBidAsk().getOrders().get(idx).getQuantity() - quantity);
                        this.products.put(product, this.products.get(product) == null ? quantity : this.products.get(product) + quantity);
                        //  ?? tradeRecordRepository.save(new TradeRecord(,,));
                        quantity = 0;
                    } else {
                        quantity -= product.getBidAsk().getOrders().get(idx).getQuantity();
                        this.products.put(product, this.products.get(product) == null ? product.getBidAsk().getOrders().get(idx).getQuantity() : this.products.get(product) + product.getBidAsk().getOrders().get(idx).getQuantity());
                        //  ?? tradeRecordRepository.save(new TradeRecord(,,));
                        product.getBidAsk().getOrders().remove(idx);
                    }
                }
            }
        }

        if (buySell == BuySell.SELL) {
            if (price > product.getBidAsk().getOrders().get(idx - 1).getPrice()) {
                product.getBidAsk().getOrders().add(new Order(this.id, buySell, price, quantity, LocalDateTime.now()));
            } else {
                while (quantity > 0 && product.getBidAsk().getOrders().get(idx - 1).getPrice() > price) {
                    if (product.getBidAsk().getOrders().get(idx - 1).getQuantity() > quantity) {
                        product.getBidAsk().getOrders().get(idx - 1).setQuantity(product.getBidAsk().getOrders().get(idx - 1).getQuantity() - quantity);
                        this.products.put(product, this.products.get(product) == null ? quantity : this.products.get(product) + quantity);
                        //  ?? tradeRecordRepository.save(new TradeRecord(,,));
                        quantity = 0;
                    } else {
                        quantity -= product.getBidAsk().getOrders().get(idx - 1).getQuantity();
                        this.products.put(product, this.products.get(product) == null ? product.getBidAsk().getOrders().get(idx - 1).getQuantity() : this.products.get(product) + product.getBidAsk().getOrders().get(idx - 1).getQuantity());
                        //  ?? tradeRecordRepository.save(new TradeRecord(,,));
                        product.getBidAsk().getOrders().remove(idx - 1);
                    }
                }
            }
        }
        if (quantity > 0)
            product.getBidAsk().getOrders().add(new Order(this.id, buySell, price, quantity, LocalDateTime.now()));
        Collections.sort(product.getBidAsk().getOrders());
    }


}
