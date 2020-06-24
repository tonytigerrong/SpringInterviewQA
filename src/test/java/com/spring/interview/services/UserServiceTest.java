package com.spring.interview.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.interview.entities.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	void getUserByNameTest() {
		String firstname = "David";
		String lastname  = "Green";
		User user = userService.getUserByName(firstname,lastname);
		assertTrue(
					user.getFirstName().equals(firstname) && user.getLastName().equals(lastname)
				);
	}

}
