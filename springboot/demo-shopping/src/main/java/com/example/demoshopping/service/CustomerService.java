package com.example.demoshopping.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.example.demoshopping.model.Customer;

public interface CustomerService {

    List<Customer> findAll();
    
    Customer create(String name, String email, LocalDate dob);

    Optional<Customer> find(long id);

    Customer create(Customer customer);

    Customer remove(long id);

    Customer update(long id, Customer customer);

    Customer patchEmail(long id, String email);

    Customer patchName(long id, String name);

}
