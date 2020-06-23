package com.spring.interview.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.interview.dao.BaseDao;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TestServiceTest {

	@Mock
	BaseDao dao;
	
	@InjectMocks
	TestService testService;
	
	@Before
	public  void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void getTestDataTest() {
		List<String> mockStrList = Arrays.asList("test1","test2","test3");
		when(dao.getTestData()).thenReturn(mockStrList);
		List<String> result = testService.getTestData("");
		for (String str : result) {
			System.out.println(str);
		}
	}

}
