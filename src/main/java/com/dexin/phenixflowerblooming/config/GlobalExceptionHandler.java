package com.dexin.phenixflowerblooming.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleBindException(MethodArgumentNotValidException ex) {

        BindingResult bindingResult=ex.getBindingResult();

        StringBuilder errorStr=new StringBuilder();

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors=bindingResult.getFieldErrors();

            for (FieldError fieldError:fieldErrors) {
                errorStr.append(fieldError.getField());
                errorStr.append(":");
                errorStr.append(fieldError.getDefaultMessage());
                errorStr.append("\n");

//                log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
            }
        }

        Map<String,Object> result = new HashMap<String,Object>();
        result.put("errCode", "51002");
        result.put("errMsg", errorStr.toString());
        return result;
    }

    @ExceptionHandler(BindException.class)
    public Map<String,Object> handleBindException(BindException ex) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        FieldError fieldError = ex.getBindingResult().getFieldError();
//        log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("errCode", "51002");
        result.put("errMsg", fieldError.getDefaultMessage());
        return result;
    }
}
