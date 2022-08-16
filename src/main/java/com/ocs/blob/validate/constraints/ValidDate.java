package com.ocs.blob.validate.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidDateConstraint.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface ValidDate {
    String message() default "date is not valid"; // default error message

    Class<?>[] groups() default {}; // required

    Class<? extends Payload>[] payload() default {};

    int allowedYearsFuture() default 1;

    int allowedYearsPast() default 1;
}
