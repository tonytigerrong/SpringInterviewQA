package com.spring.interview.controllers;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting(@RequestParam("name") String name, ModelMap  model) {
		model.put("name",name);
		return "greeting";
	}
}
