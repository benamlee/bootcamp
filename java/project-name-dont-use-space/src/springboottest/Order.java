package springboottest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Order implements Comparable<Order> {
    // show 出來的盤

    long traderid;

    BuySell buySell; // 方向

    double price; // 出價

    int quantity; // 股數

    LocalDateTime time;

    public Order(BuySell buySell, double price, int quantity, LocalDateTime time) {
        this.buySell = buySell;
        this.price = price;
        this.quantity = quantity;
        this.time = time;
    }

    @Override
    public int compareTo(Order o) {
        // order by buysell, price, time
        // bbbbbbssssss
        //
        if (this.buySell == o.buySell) {
            if (o.price != this.price) {
                return o.price < this.price ? 1 : -1;
            } else {
                return o.time.isBefore(this.time) ? 1 : -1;
            }
        }
        // if(buysell not same)
        if (this.buySell == BuySell.BUY)
            return -1;
        return 1;
    }

    @Override
    public String toString(){
        return "[order="+this.buySell.name()+" "+this.price+" "+this.quantity+" "+this.time+"]";
    }


    public static void main(String[] args) {
        List<Order> orders = new LinkedList<>();
orders.add(new Order(BuySell.SELL, 103, 9999, LocalDateTime.of(2023, 10, 11, 9, 1, 1)));
orders.add(new Order(BuySell.BUY, 96, 10, LocalDateTime.of(2023, 10, 11, 9, 1, 2)));
orders.add(new Order(BuySell.SELL, 103, 10, LocalDateTime.of(2023, 10, 11, 9, 1, 3)));
orders.add(new Order(BuySell.BUY, 98, 10, LocalDateTime.of(2023, 10, 11, 9, 1, 4)));
orders.add(new Order(BuySell.SELL, 109, 10, LocalDateTime.of(2023, 10, 11, 9, 1, 5)));
orders.add(new Order(BuySell.BUY, 100, 10, LocalDateTime.of(2023, 10, 11, 9, 1, 6)));

Collections.sort(orders);
System.out.println(orders);
orders.remove(1);
System.out.println(orders);
orders.remove(1);
System.out.println(orders);
orders.remove(1);
System.out.println(orders);
    }


}
