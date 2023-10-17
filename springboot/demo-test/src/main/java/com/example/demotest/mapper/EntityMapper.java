package com.example.demotest.mapper;

import com.example.demotest.entity.StudentEntity;
import com.example.demotest.model.Student;

public class EntityMapper {

    public static Student map(StudentEntity entity) {
        return Student.builder() //
                .name(entity.getName()) //
                .age(entity.getAge()) //
                .build(); //
    }
}
