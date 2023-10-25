package com.hkjava.demo.demojunittest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.hkjava.demo.demojunittest.entity.StudentEntity;
import com.hkjava.demo.demojunittest.repository.StudentRepository;

@DataJpaTest
public class StudentRepositoryTest {

  @Autowired
  private StudentRepository stockRepository;

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
    List<StudentEntity> studentEntities = stockRepository.findAll();
    assertThat(studentEntities.size(), equalTo(2));
    assertThat(studentEntities, hasItem(hasProperty("id", equalTo(1L))));
    assertThat(studentEntities, hasItem(hasProperty("name", equalTo("XYZ"))));
    assertThat(studentEntities, hasItem(hasProperty("age", equalTo(20))));

  }

}
