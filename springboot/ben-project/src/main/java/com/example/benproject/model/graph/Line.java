package com.example.benproject.model.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.function.IntFunction;

public class Line {

    private String symbol;

    private Interval interval;

    private List<Point> closePoints;

    // 用filter?? last day of week/ month


    public List<Point> movingAverage(int noOfInterval) {
        double sum = 0;
        double[] a =
                this.closePoints.stream().map(p -> p.getClosePrice().getPrice())
                        .mapToDouble(Double::doubleValue).toArray();
        for (int i = 0; i < noOfInterval; i++) {
            sum+=a[i];
        }
        List<Point> ma = new ArrayList<>();
        
        return null;
    }


}
