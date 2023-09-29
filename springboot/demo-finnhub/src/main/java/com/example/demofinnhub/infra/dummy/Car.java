package com.example.demofinnhub.infra.dummy;

import org.springframework.stereotype.Component;
import lombok.Getter;

@Getter
@Component
public class Car {

    int speed = 0;

    public Car(int speed) {
        this.speed = speed;
    }

    public Car() {} // necessary for @Autowired
}
