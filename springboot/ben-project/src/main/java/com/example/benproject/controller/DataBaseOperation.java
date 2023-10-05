package com.example.benproject.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.entity.Quote;

public interface DataBaseOperation {

    // @PostMapping(value = "/data/companyprofile")
    // @ResponseStatus(value = HttpStatus.OK)
    // CompanyProfile save(@RequestBody CompanyProfile companyProfile);

    @GetMapping(value = "/data/companyprofiles")
    @ResponseStatus(value = HttpStatus.OK)
    List<CompanyProfile> findAllCompanyProfiles();

    @GetMapping(value = "/data/quotes")
    @ResponseStatus(value = HttpStatus.OK)
    List<Quote> findAllQuotes();

    // @PostMapping(value = "/data/companyprofile")
    // @ResponseStatus(value = HttpStatus.OK)
    // CompanyProfile saveCompanyProfile(@RequestBody CompanyProfile companyProfile);

// @PostMapping(value = "")

}
