package com.example.benproject.model.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Point {
    
    private Price closePrice;

    private TranDayTime tranDayTime;

    public Point(double closePrice, TranDayTime tranDayTime) {
        this.closePrice = new Price(closePrice);
        this.tranDayTime = tranDayTime;
    }


}
