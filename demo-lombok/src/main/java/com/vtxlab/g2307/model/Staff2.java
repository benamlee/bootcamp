package com.vtxlab.g2307.model;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder // parent also use superbuilder and here can .superattribute()
public class Staff2 extends Human {
    private double salary;

    // have to manually code the constructor with Parent's attribute
    public Staff2(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public static void main(String[] args) {
        Staff2 staff = new Staff2("John", 3000.0);
        Staff2 staff2 = new Staff2("Peter", 3000.0);
        Staff2 staff3 = new Staff2("John", 3000.0);
        System.out.println(staff.equals(staff2)); // false

        System.out.println(staff.equals(staff3)); // true
        // 如果Human都有@EqualsAndHashCode，staff.equals(staff3)==true
        Staff2 s4 = Staff2.builder()
        .name("Mary")
        .salary(20000)
        .build();
    }
}
