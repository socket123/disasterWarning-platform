package com.yoxnet.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.yoxnet.api.validation.validator.IsNumericValidator;

/**
 * 数字注解
 *
 * @author huangyong
 * @since 1.0.0
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsNumericValidator.class)
public @interface IsNumeric {

    String message() default "is_numeric";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
