package com.spring.interview.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.interview.interceptors.ControllerInterceptor;

@Configuration
public class InterceptorConfigRegister extends WebMvcConfigurerAdapter{
	@Autowired
	ControllerInterceptor controllerInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.controllerInterceptor);
	}
}
