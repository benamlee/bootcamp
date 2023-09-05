package com.vtxlab.g2307.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// @NoArgsConstructor // 如果本身冇寫empty constructor, 寫呢個唔會撞
@EqualsAndHashCode(callSuper = false)
// @AllArgsConstructor // 不考慮parent class attribute
public class Staff extends Human {
    private double salary;

    // have to manually code the constructor with Parent's attribute
    public Staff(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public static void main(String[] args) {
        Staff staff = new Staff("John", 3000);
        Staff staff2 = new Staff("Peter", 3000);
        Staff staff3 = new Staff("John", 3000);
        System.out.println(staff.equals(staff2)); // true
        // System.out.println(staff == staff2); // false
        System.out.println(staff.equals(staff3)); // true
    }
}

