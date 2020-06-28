package com.spring.interview.validations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring.interview.validations.AgerConstraint;

public class AgeValidator implements
ConstraintValidator<AgerConstraint, Integer> {

  @Override
  public void initialize(AgerConstraint contactNumber) {
  }

  @Override
  public boolean isValid(Integer contactField,
    ConstraintValidatorContext cxt) {
      return contactField > 5 && contactField <15;
  }

 

}