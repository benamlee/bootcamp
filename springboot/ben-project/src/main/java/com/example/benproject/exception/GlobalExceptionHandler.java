package com.example.benproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.benproject.infra.ApiResponse;
import com.example.benproject.infra.Code;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = FinnhubException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<Void> finnhubExceptionHandler(FinnhubException e) {
        return ApiResponse.<Void>builder() //
                .status(Code.fromCode(e.getCode())) //
                .data(null) //
                .build();
    }
}
