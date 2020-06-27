package com.spring.interview.services;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

//@Service
public class MyInternationalMessage {
	private ResourceBundle resourceBundle;
//	public MyInternationalMessage(String resourceName){
//		this.resourceBundle = ResourceBundle.getBundle(resourceName);
//	}
	public MyInternationalMessage(String resourceName, String local1, String local2){
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		this.resourceBundle = ResourceBundle.getBundle(resourceName);
		Locale.setDefault(new Locale(local1,local2));
		
	}
	public String getMessage(String key) {
		return this.resourceBundle.getString(key);
	}
}
