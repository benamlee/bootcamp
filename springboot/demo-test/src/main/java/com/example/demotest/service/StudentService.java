package com.example.demotest.service;

import org.springframework.stereotype.Service;
import com.example.demotest.model.Student;

@Service
public class StudentService {

    public String getStudentName(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        return this.getDB();
    }

    public String getDB() {
        return new Student("John", 30).concat("Chan");
    }
}
