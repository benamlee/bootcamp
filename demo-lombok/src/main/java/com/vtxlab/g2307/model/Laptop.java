package com.vtxlab.g2307.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Laptop {
    private String os;
    @Setter
    private int memory;

    public static void main(String[] args) {
        Laptop laptop = new Laptop("Windows", 32);
        System.out.println(laptop.getMemory());
        System.out.println(laptop.getOs());
        laptop.setMemory(64);
        // laptop.setOs("Mac"); // no setter on OS
    }
}
