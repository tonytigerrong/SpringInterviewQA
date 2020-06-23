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
	BaseDao dao; // need mock in init function, for isolation servcie and test

	@InjectMocks
	TestService testService; // inject mocks is instance which invoke a mocked instance

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getTestDataTest() {
		List<String> mockStrList = Arrays.asList("test1", "test2", "test3");
		// when we invoke dao.getTestData(), then we get a mocked return result
		when(dao.getTestData()).thenReturn(mockStrList);
		// instance of testService invokes dao which is mocked
		List<String> result = testService.getTestData("");
		for (String str : result) {
			System.out.println(str);
		}
		assertTrue(result.get(0).equals("test1"));
		assertTrue(result.get(1).equals("test2"));
		assertTrue(result.get(2).equals("test3"));
	}

}
