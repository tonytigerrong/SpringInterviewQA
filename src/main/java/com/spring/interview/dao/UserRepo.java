package com.spring.interview.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.interview.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	
	
}
