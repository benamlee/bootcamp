package com.example.benproject.model.trade;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Trader {

    // Buyer Seller
    private long id;

    private double money;

    private HashMap<Product, Integer> products; //

    // 可以做：在指定 BidAsk 做 new order 的 method

    public synchronized void order(Product product, BuySell buySell, double price, int quantity) {

        // check if trader have sufficent product for sell
        // have sufficient money for buy

        Order order = new Order(this.id, buySell, price, quantity, LocalDateTime.now());

        // 先check 對唔對到, 對到就成交, 有剩就加入


  product.getBidAsk().getOrders(); // check 能否成交
        
  // 如果order 對唔到, 就加入list
        if () {
        product.getBidAsk() //
        .getBuyOrders() //
        .add(order);
        } else { 
            // 成交，加HashMap
            // trade record 寫入database

        }

      
    }



    // 10人, 2人trade, 8人睇, 每5秒refresh read
    // 如果買哂，有剩繼續排盤

}
