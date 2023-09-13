package com.example.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {
        @GetMapping(value = "/strings")
        List<String> getStrings();


        // http://127.0.0.1:8081/api/v1/add?x=1&y=2
        // Json pass data should not use primitives
        @GetMapping(value = "/add")
        Integer add(@RequestParam(name = "x") int salary, // default: required = true
                        @RequestParam(name = "y") int bonus, //
                        @RequestParam(name = "z", required = false,
                                        defaultValue = "100") String dividend,
                        @RequestParam(required = false) int k);

        // http://127.0.0.1:8081/api/v1/substract/10/20
        // http://127.0.0.1:8081/api/v1/substract/10/20/30
        @GetMapping(value = {"/substract/{x}/{y}/{z}", "/substract/{x}/{y}"}) // 隱藏了param名
        // path 要寫哂所有可能性
        Integer substract(@PathVariable(name = "x") int salary, //
                        @PathVariable int y, //
                        @PathVariable(required = false) String z);

}
