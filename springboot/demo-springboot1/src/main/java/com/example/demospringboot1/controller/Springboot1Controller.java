package com.example.demospringboot1.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface Springboot1Controller {
    
    @GetMapping(value = "/helloworld")
    String hello();
}
