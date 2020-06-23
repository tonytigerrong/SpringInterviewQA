package com.spring.interview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.interview.dao.BaseDao;

@Service
public class TestService {
	@Autowired
	BaseDao dao;

	public List<String> getTestData(String name) {
		return dao.getTestData();
	}
}
