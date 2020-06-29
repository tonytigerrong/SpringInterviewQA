package com.spring.interview.dao;

import java.util.List;

import com.spring.interview.entities.User;

public interface UserDAO {
	public void save(User user);
	public List<User> list();
}
