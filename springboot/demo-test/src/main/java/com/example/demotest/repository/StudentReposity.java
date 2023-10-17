package com.example.demotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demotest.entity.StudentEntity;

@Repository
public interface StudentReposity extends JpaRepository<StudentEntity, Long> {

}
