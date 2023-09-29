package com.example.benproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {

    @Value(value = "{api.finnhub.token}")
    private String token;

    @Bean
    String finnhubToken() {
        return token; // only token key
    }

    @Bean
    RestTemplate restTemplate() { // getForObject
        return new RestTemplate(); // UriComponentsBuilder
    } // Define the return type (Object or Array)

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
