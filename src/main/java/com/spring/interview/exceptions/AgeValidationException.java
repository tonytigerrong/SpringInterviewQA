package com.spring.interview.exceptions;

public class AgeValidationException extends RuntimeException {
	public AgeValidationException(String message) {
		super(message);
		System.out.println("AgeValidationException found ");
	}
}
