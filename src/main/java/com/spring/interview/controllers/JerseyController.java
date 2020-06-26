package com.spring.interview.controllers;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.spring.interview.entities.User;
import com.spring.interview.services.UserService;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class JerseyController {

	@Autowired
	private UserService userService;

	@GET
	@Path("/{firstname}/{lastname}/")
	public User getUser(@PathParam("firstname") String firstName, @PathParam("lastname") String lastName,
						@QueryParam("isTest") String isTest
			
			) {
		
		User user = null;
		
		if(isTest.equals(""))
			user = userService.getUserByName(firstName, lastName);
		else
			user = new User("firstname", "lastname", 0, null);
		return user;

	}
}
