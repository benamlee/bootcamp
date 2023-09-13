package com.example.demosbhelloworld2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/目錄")
public class HelloworldController {

    @GetMapping(value = "/page1")
    public String try321321() {
        return "yes i can do it!!!!!!!!!!!!!!!!!";
    }
}
