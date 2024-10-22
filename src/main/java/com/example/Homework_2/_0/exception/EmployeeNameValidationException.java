package com.example.Homework_2._0.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNameValidationException extends RuntimeException{
    private final String param;

    public EmployeeNameValidationException(String param) {
        super("[%s] include invalid symbols".formatted(param));
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
