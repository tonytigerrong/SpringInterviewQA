package com.spring.interview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.interview.services.TestService;

@Controller
public class GreetingController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting(@RequestParam("name") String name, ModelMap  model) {
		List<String> names = testService.getTestData(name);
		model.put("names",names);
		return "greeting";
	}
}