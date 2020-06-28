package com.spring.interview.validations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.spring.interview.validations.MyValidatorContactNumber;

public class MyContactNumberValidator implements ConstraintValidator<MyValidatorContactNumber, Object> {
	private String field;
    private String fieldMatch;
    public void initialize(MyValidatorContactNumber myValidatorContactNumber) {
        this.field = myValidatorContactNumber.field();
        this.fieldMatch = myValidatorContactNumber.fieldMatch();
    }
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
        
        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
	}

}
