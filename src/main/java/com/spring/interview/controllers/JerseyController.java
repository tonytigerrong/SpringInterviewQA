package com.spring.interview.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	@Path("/{firstname}/{lastname}")
    public User getUser(@PathParam("firstname") String firstName, @PathParam("lastname") String lastName) {
        User user = userService.getUserByName(firstName,lastName);
		return user;
        
    }
}
