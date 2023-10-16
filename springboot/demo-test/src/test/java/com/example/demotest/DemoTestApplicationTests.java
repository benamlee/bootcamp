package com.example.demotest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // full-context
// 模擬一次mvn spring boot run
// spring boot test 死哂可以照行到spring boot run
// mvn spring boot run 會skip SpringBootTest
class DemoTestApplicationTests {

	@Test
	void contextLoads() {
	}

}
