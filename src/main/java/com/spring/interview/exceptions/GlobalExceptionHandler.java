package com.spring.interview.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Spring 3
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({CustomCheckedException1.class, CustomUncheckedException1.class})
	public void handleException() {
		System.out.println("Global Exception Handler default");
	}
}
