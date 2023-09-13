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
public class Springboot1ControllerImpl implements Springboot1Controller{
    
@Autowired
HelloworldService helloworldService;

@Override
public String hello() {
    // return "Hello world. I am Ben. Springboot1.";
    return helloworldService.generate(102);
}

}
