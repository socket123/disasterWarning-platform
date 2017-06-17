package com.yoxnet.api.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yoxnet.api.util.StringUtil;
import com.yoxnet.api.validation.NotEmpty;

/**
 * 非空注解验证器
 *
 * @author huangyong
 * @since 1.0.0
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

    @Override
    public void initialize(NotEmpty constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtil.isNotEmpty(value);
    }
}
