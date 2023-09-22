package com.example.demoresttemplate.exception;

import com.example.demoresttemplate.infra.BusinessException;
import com.example.demoresttemplate.infra.Code;

public class JPHException extends BusinessException{
    
    public JPHException(Code code) {
        super(code);
    }
    
}
