package com.example.demotest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demotest.model.Student;
import com.example.demotest.service.StudentService;

@Controller
@ResponseBody
@RequestMapping("/v1")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{name}")
    public String getStudentName(@PathVariable String name) {
        return studentService.getStudentName(name);
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

}
