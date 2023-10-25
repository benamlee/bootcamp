package com.hkjava.demo.demojunittest.mapper;

import com.hkjava.demo.demojunittest.entity.StudentEntity;
import com.hkjava.demo.demojunittest.model.Student;

public class EntityMapper {

  public static Student map(StudentEntity entity) {
    return Student.builder() //
        .name(entity.getName()) //
        .age(entity.getAge()) //
        .build();
  }
}
