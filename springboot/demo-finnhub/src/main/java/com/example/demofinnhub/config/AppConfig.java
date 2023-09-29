package com.example.demofinnhub.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.example.demofinnhub.infra.AppleRestClient;
import com.example.demofinnhub.infra.RedisHelper;
import com.example.demofinnhub.infra.RedisObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

    @Value(value = "${api.finnhub.token}")
    private String token;

    @Bean
    ModelMapper modelMapper() { //
        return new ModelMapper();
    }

    @Bean
    String finnhubToken() {
        return token;
    }

    @Bean
    AppleRestClient stockService(RestTemplate restTemplate) {
        return new AppleRestClient(restTemplate); // input need autowired?????
    }

    @Bean
    RestTemplate restTemplate() { // method name -> bean name
        return new RestTemplate();
    }
  @Bean
  ObjectMapper redisObjectMapper() {
    return RedisObjectMapper.of();
  }

  @Bean
  RedisHelper redisProfileHelper(RedisConnectionFactory factory,
      ObjectMapper redisObjectMapper) {
    return new RedisHelper(factory, redisObjectMapper);
  }

}
