package com.example.demofinnhub.model.test2;

import java.time.LocalDate;
import java.util.List;

public class HistoryPrice {

    // private String type; // enum: DAY, WEEK, MONTH, HOUR, 30_MINUTE

    private double closePrice; // 60.85

    private LocalDate tranDateTime; // 2023-09-28 11:30:00
    // 2023-09-28 11:30:00
    // 2023-09-28 12:00:00
    // 2023-09-28 13:00:00
    // 2023-09-28 13:30:00

  private List<Price> prices; // this list has data

  public List<Double> movingAvg(enum: DAY, int 50) {
    int[]a = new int[]{1,2,3};
    String s = "abc";
    StringBuilder ss = new StringBuilder(s).reverse();
    s= ss.toString();
    }
}
