package com.example.demotest;

import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.example.demotest.entity.StudentEntity;
import com.example.demotest.model.Student;
import com.example.demotest.repository.StudentReposity;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentReposity studentReposity;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindAll(){
        // save (entityManager)
        // findAll
        StudentEntity student = new StudentEntity("ABC", 12);
        StudentEntity student2 = new StudentEntity("IJK", 22);
        StudentEntity student3 = new StudentEntity("XYZ", 32);
    List<StudentEntity> students = List.of(student,student2,student3);
    entityManager.persist(student);



// findAll
List<StudentEntity> studentEntities = studentReposity.findAll();
assertThat(studentEntities, hasItem(hasProperty("id", equalTo(1L))));



    }
}
