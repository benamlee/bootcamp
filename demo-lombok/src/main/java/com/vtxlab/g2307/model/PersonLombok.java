package com.vtxlab.g2307.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor // annotation
@NoArgsConstructor
@Getter
@Setter // write them here to apply on all attribute 
@ToString(onlyExplicitlyIncluded = true)
// public class PersonLombok extends Person{ // extends 左不能用@AllArgsConstructor @NoArgsConstructor
public class PersonLombok {
    @Setter
    @Getter
    private String name; // getter setter here -> only this one has

    @ToString.Include
    private int age;

    public PersonLombok(String name) {
        this(name, 10);
    }


    public static void main(String[] args) {
        PersonLombok personLombok = new PersonLombok("Peter", 30); // AllArgsConstructor
        PersonLombok p2 = new PersonLombok(); // NoArgsConstructor
        p2.setAge(13);
        p2.setName("Eric");
        System.out.println(p2.getAge());
        System.out.println(p2.getName());
        System.out.println(p2); // lombok toString
        System.out.println(personLombok); // lombok toString
    }
}
