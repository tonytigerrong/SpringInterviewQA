package com.spring.interview.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.interview.entities.User;



@SpringBootTest
class BaseDaoTest {

	@Autowired
	BaseDao dao;
	@Test
	void getUserTest() {
		String firstname = "David";
		String lastname  = "Green";
		User user = dao.getUserByName( firstname, lastname);
		Assertions.assertTrue(user.getFirstName().equals(firstname) && user.getLastName().equals(lastname));
	}

}
