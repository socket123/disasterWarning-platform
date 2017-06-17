package com.yoxnet.api.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yoxnet.api.validation.LessThan;

/**
 * 小于值注解验证器
 *
 * @author huangyong
 * @since 1.0.0
 */
public class LessThanValidator implements ConstraintValidator<LessThan, Integer> {

    private Integer value;

    @Override
    public void initialize(LessThan constraintAnnotation) {
        value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value < this.value;
    }
}