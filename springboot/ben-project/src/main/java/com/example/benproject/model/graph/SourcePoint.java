package com.example.benproject.model.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class SourcePoint {

    // static, 每股都有list of source point
    public static Map<String, List<SourcePoint>> sourceMap = new HashMap<>();

    // 每一點source data point
    private Interval interval = Interval.DAY;

    private Price closePrice;

    private TranDayTime tranDayTime;


    public Point tPoint() {
        return Point.builder() //
                .closePrice(this.closePrice) //
                .tranDayTime(this.tranDayTime) //
                .build();
    }


}
