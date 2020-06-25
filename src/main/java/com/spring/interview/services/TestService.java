package com.spring.interview.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.interview.dao.BaseDao;
import com.spring.interview.exceptions.CustomCheckedException1;
import com.spring.interview.exceptions.CustomUncheckedException1;

@Service
@PropertySource("values.properties") // field injection
public class TestService {
	@Autowired
	BaseDao dao;

	//field injection
	@Value("${name}")
	String name;
	/**
	 * called when ApplicationContext load the bean
	 */
	@PostConstruct
	public void init() {
		System.out.println("init TestService"+name);
	}
	
	/**
	 * called before ApplicationContext destory the bean 
	 */
	@PreDestroy
	public void destory() {
		System.out.println("destory TestService");
	}
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
