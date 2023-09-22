package com.example.demoshopping.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demoshopping.model.Customer;

public interface CustomerOperation {

        // "/customer" -> endpoint

        @GetMapping(value = "/customers") // noun, No verb
        List<Customer> findAll();

        @PostMapping(value = "/customer") // noun, No verb here
        Customer create(@RequestParam String name, //
                        @RequestParam String email, //
                        @RequestParam LocalDate dob);

        @GetMapping(value = "/customer/{id}") // noun, No verb
        Customer find(@PathVariable(name = "id") String customerId);

        @PostMapping(value = "/customer2") // noun, No verb
        Customer create(@RequestBody Customer customer);

        @DeleteMapping(value = "/customer/{id}") // noun, No verb
        Customer remove(@PathVariable(name = "id") String customerId);

        @PutMapping(value = "/customer/{id}") // Put -> table PK
        Customer update(@PathVariable String id, //
                        @RequestBody Customer customer); // 成個object replace

        @PatchMapping(value = "/customer/id/{id}/email/{email}")
        Customer patchEmail(@PathVariable String id, //
                        @PathVariable String email);

        @PatchMapping(value = "/customer/id/{id}/name/{name}")
        Customer patchName(@PathVariable String id, //
                        @PathVariable String name);

        // @PatchMapping(value = "/customer/{email}")
        // @PatchMapping(value = "/customer/{name}")
        // 如果咁寫會撞輸入
}
