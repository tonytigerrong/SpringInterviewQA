package com.spring.interview.configs;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.spring.interview.dao.BaseDao;
import com.spring.interview.services.TestService;
import org.mockito.Mockito;

@Profile("teststart")
@SpringBootConfiguration
public class TestServiceConfiguration {

	@Bean
	@Primary
	public TestService testService() {
		return Mockito.mock(TestService.class);
	}
	
	@Bean
	public BaseDao dao() {
		return Mockito.mock(BaseDao.class);
	}
}
