package com.example.benproject.model.graph;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candlestick {

    private LocalDateTime localDateTime;

    private double open;

    private double close;

    private double high;

    private double low;

    private int volumn;

}
