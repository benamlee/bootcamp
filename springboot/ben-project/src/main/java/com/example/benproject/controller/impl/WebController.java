package com.example.benproject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.benproject.controller.WebOperation;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.ApiResponse;
import com.example.benproject.model.dto.web.resp.CompanyProfileAndQuoteDTO;
import com.example.benproject.service.WebStockService;

@RestController
@RequestMapping(value = "/api/v1")
public class WebController implements WebOperation {

    @Autowired
    private WebStockService webStockService;

    @Override
    public ApiResponse<CompanyProfileAndQuoteDTO> getCompanyProfileAndQuoteDTO(
            String symbol) throws FinnhubException {
        return ApiResponse.<CompanyProfileAndQuoteDTO>builder() //
                .ok() //
                .data(webStockService.getCompanyProfileAndQuoteDTO(symbol)) //
                .build();
    }

}
