package com.vtxlab.g2307.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// @AllArgsConstructor
// @NoArgsConstructor
// 如果用NoArgsConstructor,final要有default value,但有default就@Req.. 個constructor會有input
// 會有bug
@RequiredArgsConstructor // @NonNull and final instance constructor
public class Car {

    @NonNull //run time exception
    private Integer capacity;

    private final double weight;
    
    private String color;

    public Car(String color) {
        this.color = color;
        this.weight = 0; // if not define weight that is final,no default value
    }

    public static void main(String[] args) {
        Car car = new Car(3, 5.0); // 只有兩個constructor(color(自己寫) / nonnull+final)
    }
}
