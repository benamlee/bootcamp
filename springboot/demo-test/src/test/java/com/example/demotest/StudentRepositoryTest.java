package com.example.demotest;

import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.example.demotest.entity.StudentEntity;
import com.example.demotest.model.Student;
import com.example.demotest.repository.StudentRepository;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentReposity;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindAll() {
        // save (entityManager)
        StudentEntity s1 = new StudentEntity("ABC", 30);
        StudentEntity s2 = new StudentEntity("XYZ", 20);
        entityManager.persist(s1);
        entityManager.persist(s2);

        // findAll
        List<StudentEntity> studentEntities = studentReposity.findAll();
        assertThat(studentEntities.size(), equalTo(2));
        assertThat(studentEntities, hasItem(hasProperty("id", equalTo(1L))));
        assertThat(studentEntities, hasItem(hasProperty("name", equalTo("XYZ"))));
        assertThat(studentEntities, hasItem(hasProperty("age", equalTo(20))));

    }
}
