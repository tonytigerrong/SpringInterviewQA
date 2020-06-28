package com.spring.interview.exceptions;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
//@ControllerAdvice // has to comment this, conflict with parent class
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	/*
	 *  for not valid check exception for both embeded and custom validator
	 *  In controller GreetingController.java , createUser function 's @valid user should catch exception here
	 *  But it's not, need to be fixed
	 */
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
}
