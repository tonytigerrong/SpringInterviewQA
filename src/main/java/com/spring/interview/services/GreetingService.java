package com.spring.interview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.interview.entities.User;

@Service
public class GreetingService {

	@Autowired
	UserService userService;
	
	@Autowired
	MyInternationalMessage myInternationalMessage;
	
	public String greet() {
		String firstname = "David";
		String lastname  = "Green";
		User user = userService.getUserByName(firstname,lastname);
		String greet = myInternationalMessage.getMessage("hello");
		return greet+" "+user.getLastName();
	}
}

