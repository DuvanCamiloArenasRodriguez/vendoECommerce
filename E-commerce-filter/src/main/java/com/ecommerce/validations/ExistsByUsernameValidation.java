package com.ecommerce.validations;

import com.ecommerce.domain.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {
    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return !service.existsByUsername(userName);
    }
}
