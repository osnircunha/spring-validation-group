package com.ocs.blob.validate.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class ValidDateConstraint implements ConstraintValidator<com.ocs.blob.validate.constraints.ValidDate, LocalDateTime> {

    private int yearsPast;
    private int yearsFuture;

    @Override
    public void initialize(ValidDate constraintAnnotation) {
        yearsPast = constraintAnnotation.allowedYearsPast();
        yearsFuture = constraintAnnotation.allowedYearsFuture();
    }

    @Override
    public boolean isValid(LocalDateTime validDate, ConstraintValidatorContext constraintValidatorContext) {
        return validDate != null
                && validDate.isBefore(LocalDateTime.now().plusYears(this.yearsFuture))
                && validDate.isAfter(LocalDateTime.now().minusYears(this.yearsPast));
    }
}
