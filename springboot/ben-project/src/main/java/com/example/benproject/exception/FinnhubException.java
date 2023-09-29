package com.example.benproject.exception;

import com.example.benproject.infra.BusinessException;
import com.example.benproject.infra.Code;

public class FinnhubException extends BusinessException {
    public FinnhubException(Code code){
        super(code);
    }
}
