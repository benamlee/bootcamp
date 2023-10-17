package com.example.demotest.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demotest.mapper.EntityMapper;
import com.example.demotest.model.Student;
import com.example.demotest.repository.StudentReposity;

@Service
public class StudentService {

    @Autowired
    private StudentReposity studentReposity;

    // @Autowired
    // private EntityMapper entityMapper;

    public String getStudentName(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        return this.getDB();
    }

    public String getDB() {
        return new Student("John", 30).concat("Chan");
    }

    public List<Student> findAll(){
        return studentReposity.findAll().stream() //
        .map(entity -> EntityMapper.map(entity)) //
        .collect(Collectors.toList()); //
    }
}
