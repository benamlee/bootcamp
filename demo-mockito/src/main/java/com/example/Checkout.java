package com.example;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // NonNull and final
public class Checkout {

    @NonNull
    @Setter
    private Calculator calculator;

    // public Checkout(Calculator calculator) {
    // this.calculator = calculator;
    // }

    public int add(int x, int y) {
        // Calculator calculator = new Calculator(weight);
        if (x > 1) {
            return y + this.calculator.substract(x, y);
        }
        return x + y;
    }

    public int multiply(int x, int y) {
        if (x > 1) {
            System.out.println(1);
            return y + this.calculator.multiply(x, y);
        } else if (x == 0) {
            System.out.println(2);
            return y + this.calculator.substract(x, y);
        }
        System.out.println(3);
        return this.calculator.multiply(x, y) + this.calculator.substract(x, y);
    }

    public int out() {
        return this.calculator.b1() + this.calculator.b2();
    }
}
