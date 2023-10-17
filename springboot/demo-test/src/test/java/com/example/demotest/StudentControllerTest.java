package com.example.demotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.demotest.controller.StudentController;
import com.example.demotest.service.StudentService;

@SpringBootTest
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @Autowired // 平時唔會咁寫
    private StudentController studentController;

    @Test
    void testService() {
        // when
        Mockito.when(studentService.getStudentName("Peter"))
                .thenReturn("Jenny Lee");
        // test
        String result = studentController.getStudentName("Peter");
        // Assert
        assertEquals("Jenny Lee", result);

    }
}
