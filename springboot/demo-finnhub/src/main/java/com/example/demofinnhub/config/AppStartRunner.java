package com.example.demofinnhub.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartRunner implements CommandLineRunner {



    @Override
    public void run(String... args) {
        // Before Server Start:
        // 0. Get all symbols (US) from the API
        // https://finnhub.io/api/v1/stock/symbol?exchange=US&token=ck5rdg9r01qls0umc6mgck5rdg9r01qls0umc6n0
        // 1. Get All Company Profile2 and insert into database
        // 2. Get Stock price and insert into database

        String s =
                "https://finnhub.io/api/v1/stock/symbol?exchange=US&token=ck5rdg9r01qls0umc6mgck5rdg9r01qls0umc6n0";
        System.out.println("runner start ....");

    }

}
