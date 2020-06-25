package com.spring.interview.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Spring 3
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {

//	@ExceptionHandler({Exception.class})
//	public void handlerAllException(Exception ex) {
//		if(ex instanceof CustomCheckedException1) {
//			System.out.println("Global exception handler catch a CustomCheckedException1");
//		}else if(ex instanceof CustomUncheckedException1) {
//			System.out.println("Global exception handler catch a CustomUncheckedException1");
//		}
//		
//	}
	
	@ExceptionHandler({CustomCheckedException1.class, CustomUncheckedException1.class})
	public ResponseEntity<Exception> handleALLException(Exception ex) {
		if(ex instanceof CustomCheckedException1) {
			System.out.println("Global exception handler catch a CustomCheckedException1");
			// spring 5
			return new ResponseEntity<Exception>( ex, HttpStatus.NOT_FOUND);
		}else if(ex instanceof CustomUncheckedException1) {
			System.out.println("Global exception handler catch a CustomUncheckedException1");
			// spring 5
			return new ResponseEntity<Exception>( ex, HttpStatus.CONTINUE);
		}else if(ex instanceof ResponseStatusException ) { // spring 5
			System.out.println("Global exception handler catch a ResponseStatusException");
			// spring 5
			return new ResponseEntity<Exception>( ex, HttpStatus.CREATED);
		}
		return null;
		
		
	}
}
