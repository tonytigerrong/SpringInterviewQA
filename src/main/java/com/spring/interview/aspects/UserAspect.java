package com.spring.interview.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//import com.spring.interview.services.UserService

@Aspect
@Component
public class UserAspect {


	@Pointcut( value = "execution(* com.spring.interview.services.UserService.getUserByName(..))")
	public void serviceGetUserByName() {}
	
	@Before("serviceGetUserByName()")
//	@Before(value="execution(* com.spring.interview.services.UserService.getUserByName(..))")
	public void beforeService_GetUserByName(JoinPoint joinPoint) {
		System.out.println("*******Before execute getUserByName method of UserService");
	}
	
	@After("serviceGetUserByName()")
	public void afterService_GetUserByName(JoinPoint joinPoint) {
		System.out.println("*******After execute getUserByName method of UserService "+joinPoint);
	}
}
