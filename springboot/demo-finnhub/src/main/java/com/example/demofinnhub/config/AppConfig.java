package com.example.demofinnhub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value(value = "{API_Key}")
    private String token;
    
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    String finnhubToken() {
        return token;
    }
}
