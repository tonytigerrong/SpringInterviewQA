package com.spring.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringInterviewQaApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringInterviewQaApplication.class, args);
//		for (String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println("****:"+name);
//		}
	}

}
