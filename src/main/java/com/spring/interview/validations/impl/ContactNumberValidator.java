package com.spring.interview.validations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring.interview.validations.ContactNumberConstraint;

public class ContactNumberValidator implements
ConstraintValidator<ContactNumberConstraint, Integer> {

  @Override
  public void initialize(ContactNumberConstraint contactNumber) {
  }

  @Override
  public boolean isValid(Integer contactField,
    ConstraintValidatorContext cxt) {
      return contactField > 5;
  }

 

}