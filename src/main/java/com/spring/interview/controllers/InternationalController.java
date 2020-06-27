package com.spring.interview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InternationalController {

	//http://localhost:8080/international?lang=fr|en
	@RequestMapping(value="international", method=RequestMethod.GET)
	public String internationalTest() {
		return "international";
	}
}
