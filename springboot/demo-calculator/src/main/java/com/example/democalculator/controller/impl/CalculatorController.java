package com.example.democalculator.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.democalculator.controller.CalculatorOperation;
import com.example.democalculator.service.CalculatorService;

// @Controller
// @ResponseBody
@RestController // i.e. @Controller + @ResponseBody
@RequestMapping(value = "/api/v1") // setting a path
public class CalculatorController implements CalculatorOperation {

    @Autowired
    CalculatorService calculatorService; // find the class that can put in this interface

    // @Autowired
    // List<String> strings;

    @Override
    public List<String> getStrings() {
        return calculatorService.getStrings();
    }

    @Override
    public Integer add(int salary, int bonus, String dividend, int k) {
        int d = 0;
        try {
            d = Integer.valueOf(dividend);
        } catch (NumberFormatException e) {
            d = 0;
        }
        return calculatorService.add(salary + bonus, d + k);
    }

    @Override
    public Integer substract(int x, int y, String z) {
        int d = 0;
        try {
            d = Integer.valueOf(z);
        } catch (NumberFormatException e) {
            d = 0;
        }
        return calculatorService.substract(x - y, d);
    }
}
