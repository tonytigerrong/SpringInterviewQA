package com.spring.interview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.interview.entities.User;
import com.spring.interview.exceptions.CustomCheckedException1;
import com.spring.interview.exceptions.CustomUncheckedException1;
import com.spring.interview.services.GreetingService;
import com.spring.interview.services.TestService;
import com.spring.interview.services.UserService;

@Controller
public class GreetingController {

	@Autowired
	private TestService testService;
	
	@Autowired
	private GreetingService greetingService;
	
	
	
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting(@RequestParam("name") String name, ModelMap  model) {
		List<String> names = testService.getTestData(name);
		model.put("names",names);
		if(name.equals("")) {
			throw new CustomUncheckedException1("error 1002", null);
		}
		return "greeting";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody String greeting2() throws CustomCheckedException1 {
		if(greetingService != null) {
			throw new CustomCheckedException1("error 1001");
		}
		return greetingService.greet();
	}
	
	@ExceptionHandler({CustomCheckedException1.class, CustomUncheckedException1.class})
	public void handleException() {
		System.out.println("_-_-_-_Exception Catch");
	}
}