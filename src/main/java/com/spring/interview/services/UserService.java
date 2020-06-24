package com.spring.interview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.interview.dao.BaseDao;
import com.spring.interview.entities.User;

@Service
public class UserService {
	@Autowired
	BaseDao dao;
	
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	
	public User getUserByName(String first, String last) {
		return dao.getUserByName(first,last);
	}
}
