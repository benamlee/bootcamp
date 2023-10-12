package com.example.benproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.ApiResponse;
import com.example.benproject.model.dto.web.resp.CompanyProfileAndQuoteDTO;

public interface WebOperation {


    @GetMapping(value = "/stock")
    @ResponseStatus(value = HttpStatus.OK)
    // RequestParam format -> .../stock?symbol=AAPL
    ApiResponse<CompanyProfileAndQuoteDTO> getCompanyProfileAndQuoteDTO(
            @RequestParam("symbol") String symbol) throws FinnhubException;

}
