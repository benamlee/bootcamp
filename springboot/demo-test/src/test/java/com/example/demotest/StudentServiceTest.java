package com.example.demotest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demotest.service.StudentService;

@SpringBootTest
public class StudentServiceTest {

    @Spy // Similar to @Autowired, but some of its method can be mocked
    private StudentService studentService;

    @Test
    void TestGetDB() {
        // when
        Mockito.when(studentService.getDB()).thenReturn("Mary Lau");
        // test
        String result = studentService.getStudentName("Dummy");
        // Assert
        assertEquals("Mary Lau", result);

        // Test and Assert
        assertThrows(IllegalArgumentException.class,
                () -> studentService.getStudentName(null));
    }
}
