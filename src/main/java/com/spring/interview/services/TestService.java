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
@PropertySource("classpath:values.properties") // field injection
public class TestService {
	//field injection can't use for immutable field
	@Autowired
	BaseDao dao;

	//field injection
	@Value("${name}")
	String name;
	
	//can usefor immutable injection, can be overried by set injection
	@Autowired
	public TestService(BaseDao dao) {
		this.dao = dao;
	}
	
	
	/**
	 * called when ApplicationContext load the bean
	 */
	@PostConstruct
	public void init() {
		System.out.println("init TestService, print field injection value:"+name);
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
