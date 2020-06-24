package com.spring.interview.exceptions;

public class CustomUncheckedException1 extends RuntimeException{
	public CustomUncheckedException1(String errMsg, Throwable err) {
		super(errMsg,err);
	}
}
