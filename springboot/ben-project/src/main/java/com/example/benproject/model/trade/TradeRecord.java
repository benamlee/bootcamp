package com.example.benproject.model.trade;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TradeRecord {

    // 落database

    // private Customer buyer;

    // private Customer seller;

    private double price;

    private int quantity;

    private LocalDateTime localDateTime;

}
