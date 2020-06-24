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
	
	private boolean signature = true;
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	
	public User getUserByName(String first, String last) {
		this.signature = this.signature == true ? false : true;
		return dao.getUserByName(first,last);
	}
}
