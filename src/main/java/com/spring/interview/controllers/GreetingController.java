package com.spring.interview.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.spring.interview.entities.User;
import com.spring.interview.exceptions.CustomCheckedException1;
import com.spring.interview.exceptions.CustomUncheckedException1;
import com.spring.interview.services.GreetingService;
import com.spring.interview.services.TestService;
import com.spring.interview.services.UserService;
import com.spring.interview.services.XmlConfigBean;

@Controller
public class GreetingController {

	@Autowired
	private TestService testService;

	@Autowired
	private GreetingService greetingService;
	
	@Autowired
	private XmlConfigBean xmlConfigBean;

	@RequestMapping(value = "/spring3uncheckedexception", method = RequestMethod.GET)
	public String spring3UncheckedException(@RequestParam(required = false) Optional<String> exceptionId)
			throws CustomCheckedException1 {
		String id = exceptionId.orElseGet(() -> null);
		if (id.equals("1")) { // test spring 3
			throw new CustomUncheckedException1("CustomUncheckedException1", null);
		} else if (id.equals("2")) { // test spring 3
			throw new CustomCheckedException1("CustomCheckedException1");
		} else if (id.equals("3")) {
			// will throw CustomUncheckedException1
			testService.throwException(true);
		} 
		return "greeting";
		 
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting(@RequestParam(required = false) Optional<String> name, ModelMap model) {
		List<String> names = testService.getTestData(name.orElseGet(() -> "null"));
		model.put("names", names);
		return "greeting";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String greeting2() throws CustomCheckedException1 {
		
		return greetingService.greet() + " , " + xmlConfigBean.toString();
	}

	@RequestMapping(value="/jerseyform", method=RequestMethod.GET)
	public String jerseyForm() {
		return "JerseyForm";
	}
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public ModelAndView  addUser() {
		return new ModelAndView("UserFormInput", "user", new User("tony","green",0,null));
	}
	@RequestMapping(value="/createuser", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> createUser(@ModelAttribute("user") @Valid User user,BindingResult result, Model m) {
		System.out.println("User is==>"+user.toString());
		if(result.hasErrors()) {
			System.out.println("BindingResult==>"+result);
        }
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	/**
	 * only works at @Controller level !! Spring 3
	 */
//	@ExceptionHandler({CustomCheckedException1.class, CustomUncheckedException1.class})
//	public void handleException() {
//		System.out.println("_-_-_-_Exception Catch");
//	}
}