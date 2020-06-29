package com.spring.interview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.interview.dao.BaseDao;
import com.spring.interview.dao.UserDAO;
import com.spring.interview.dao.UserRepo;
import com.spring.interview.entities.Address;
import com.spring.interview.entities.User;

@Service
public class UserService {
	@Autowired
	BaseDao dao;
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserDAO userDAO;
	
	private boolean signature = true;
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	
	public User getUserByName(String first, String last) {
		this.signature = this.signature == true ? false : true;
		return dao.getUserByName(first,last);
	}
	
	public void saveUserTest() {
		Address address = new Address("street name","City name","Province name", "Canada");
		User user = new User("Smith","Green",11,address);
		userRepo.save(user);
	}
	
	public List<User> getUsers(){
		Iterable<User> it = userRepo.findAll();
		List<User> users = new ArrayList<User>();
		it.forEach( e->users.add(e));
		return users;
	}
	public List<User> getUsersHibernate(){
		List<User> users = userDAO.list();
		return users;
	}
}
