package com.example.demoresttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig { // Bean

    /**
     * RestTemplate is a tool/ class (library) to invoke third party APIs
     * restTemplate object can be with lots of state/ Variables
     * @return
     */

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate(); // lots of states/ Variables
    }

}
