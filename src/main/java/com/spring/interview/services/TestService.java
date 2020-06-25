package com.spring.interview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.interview.dao.BaseDao;
import com.spring.interview.exceptions.CustomCheckedException1;
import com.spring.interview.exceptions.CustomUncheckedException1;

@Service
public class TestService {
	@Autowired
	BaseDao dao;

	public List<String> getTestData(String name) {
		return dao.getTestData();
	}
	
	public String throwException(boolean wantThrow)  {
		if(wantThrow)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found",
					new CustomUncheckedException1("CustomUncheckedException1", null));
		else
			return "";
	}
}
