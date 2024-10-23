package com.example.Homework_2._0.validation;

import com.example.Homework_2._0.exception.EmployeeNameValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ValidationService {
    public void validate(String... string) {
        for (String s : string) {
            if (!StringUtils.isAlpha(s)) {
                throw new EmployeeNameValidationException(s);
            }
        }
    }
}
