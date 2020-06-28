package com.spring.interview.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Spring 3
//@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {//extends ResponseEntityExceptionHandler  {

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
	
	/*
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        System.out.println("()()()()()"+body);
        return new ResponseEntity<>(body, headers, status);
    }
    */
}
