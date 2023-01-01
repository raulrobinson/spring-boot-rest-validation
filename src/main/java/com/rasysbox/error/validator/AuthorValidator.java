package com.rasysbox.error.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class AuthorValidator implements ConstraintValidator<Author, String> {

    List<String> authors = Arrays.asList("rasysbox", "Raul Robinson", "raulrobinson", "Robinson Navas");

    /**
     * Validation Author.
     * @param value String
     * @param context ConstraintValidatorContext
     * @return boolean
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return authors.contains(value);
    }
}
