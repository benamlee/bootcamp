package com.example.demofinnhub.exception;

import com.example.demofinnhub.infra.BusinessException;
import com.example.demofinnhub.infra.Code;

public class FinnhubException extends BusinessException {

    public FinnhubException(Code code) {
        super(code);
    }
    
}
