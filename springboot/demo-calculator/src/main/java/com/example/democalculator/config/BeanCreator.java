package com.example.democalculator.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Member of @Component
public class BeanCreator {

    @Bean(name = "arraylist")
    List<String> createArrayList() {
        List<String> strings = new ArrayList<>();
        strings.add("Ben");
        strings.add("is");
        strings.add("hardworking");
        return strings;
    }

    @Bean(name = "linkedlist")
    List<String> createLinkedList() {
        List<String> strings = new LinkedList<>();
        strings.add("Taday");
        strings.add("is");
        strings.add("beautiful");
        return strings;
    }


    // @Bean ...
}
