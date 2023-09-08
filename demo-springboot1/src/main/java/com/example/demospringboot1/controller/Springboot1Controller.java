package com.example.demospringboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1") // verson 1 api set
public class Springboot1Controller {
    
@GetMapping(value = "/helloworld")
public String helloworld() {
    return "Hello world. I am Ben.";
}

}
