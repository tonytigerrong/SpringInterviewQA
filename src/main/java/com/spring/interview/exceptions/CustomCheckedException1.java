package com.spring.interview.exceptions;

public class CustomCheckedException1 extends Exception {
	public CustomCheckedException1(String errMsg) {
		super(errMsg);
		System.out.println("Custome Checked Exception:"+errMsg);
	}
}
