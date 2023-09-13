package com.example.demospringboot1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demospringboot1.controller.Springboot1Controller;
import com.example.demospringboot1.service.HelloworldService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1") // verson 1 api set
public class Springboot1ControllerImpl implements Springboot1Controller {

    @Autowired // check if any object implementing HelloworldService
    HelloworldService helloworldService; // this is an interface
    // only one class can implement this interface otherwise if more than one, or non, it dont know which one to apply

    // 有state ???
    // int age;

    // public void setAge(int age) {
    //     this.age = age;
    // }

    @Override
    public String hello() {
        // return "Hello world. I am Ben. Springboot1.";
        return helloworldService.generate(102);
    }

}
