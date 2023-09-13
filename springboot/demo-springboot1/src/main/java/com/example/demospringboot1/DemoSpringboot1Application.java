package com.example.demospringboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// this annotation is >>>>>
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan (Most Important)

// ComponentScan is to scan @Controller, @Service, @Repository, @Configuration
// if yes, create an object of those classes
// and put that object into SpringContext
public class DemoSpringboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringboot1Application.class, args);
	}

}
