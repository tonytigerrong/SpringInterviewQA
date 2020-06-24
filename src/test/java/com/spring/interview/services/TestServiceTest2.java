package com.spring.interview.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.interview.SpringInterviewQaApplication;
import com.spring.interview.configs.TestServiceConfiguration;

@ActiveProfiles("teststart") //switch: start load testserviceconfiguration bean loading, get mock instance of testServie
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestServiceConfiguration.class) //load configuration java file
class TestServiceTest2 {

	@Autowired
	TestService testService;
	
	@Test
	void test() {
		List<String> mockStrList = Arrays.asList("test1", "test2", "test3");
		// when we invoke dao.getTestData(), then we get a mocked return result
		when(testService.getTestData("")).thenReturn(mockStrList);
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
