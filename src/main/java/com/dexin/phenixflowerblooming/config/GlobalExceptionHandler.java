package com.dexin.phenixflowerblooming.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,Object> illegalArgumentException(IllegalArgumentException ex) {
        Map<String,Object> result = new HashMap<>();

        ex.printStackTrace();
        result.put("errCode", "50000");
        result.put("errMsg", ex.getMessage());

        return result;
    }
}
