package com.example.democalculator.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.democalculator.service.CalculatorService;

@Service // must put on class, not interface, abstract class, ...
public class CalculatorServiceimpl implements CalculatorService {

    @Autowired
    @Qualifier(value = "arraylist")
    // @Qualifier(value = "linkedlist")
    List<String> strings; // here need that List of String

    @Override
    public List<String> getStrings() {
        return this.strings;

    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int substract(int x, int y) {
        return x - y;
    }
}
