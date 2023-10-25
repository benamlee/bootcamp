package com.hkjava.demo.demojunittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.hkjava.demo.demojunittest.controller.StudentController;
import com.hkjava.demo.demojunittest.service.StudentService;

@SpringBootTest
public class StudentControllerTest {
  
  @MockBean
  private StudentService studentService;

  @Autowired
  private StudentController studentController;

  @Test
  void testService() {
    // when
    Mockito.when(studentService.getStudentName("Peter")).thenReturn("Jenny Lee");
    // test
    String result = studentController.getStudentName("Peter");
    // Assert
    assertEquals("Jenny Lee", result);
  }

  
}
