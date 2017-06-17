package com.yoxnet.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.yoxnet.api.validation.validator.LessThanValidator;

/**
 * 小于值注解
 *
 * @author huangyong
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LessThanValidator.class)
public @interface LessThan {

    String message() default "less_than";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();
}
