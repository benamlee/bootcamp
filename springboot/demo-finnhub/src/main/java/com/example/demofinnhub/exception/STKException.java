package com.example.demofinnhub.exception;

import com.example.demofinnhub.infra.BusinessException;
import com.example.demofinnhub.infra.Code;

public class STKException extends BusinessException {
    public STKException(Code code) {
        super(code);
    }
}
