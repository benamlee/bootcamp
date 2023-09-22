package com.example.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Hamcrest -> Matches
// JUnit5 -> jupiter -> @Mock, @InjectMock, Mockito (When)
// Spring Test Framework -> @WebMvcTest
// What is @SpringBootTest

// I am going to test the Server Start Process, with dependency checking
@SpringBootTest // With a complete context
// when mvn test -> Simulate App Server Start & Bean Injection on Context
class ApplicationTests {

	@Test
	void contextLoads() { // Test Server Start
	}

}
