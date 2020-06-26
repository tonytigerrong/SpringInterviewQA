package com.spring.interview.configs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/")
public class JerseyAppConfig extends ResourceConfig {
	public JerseyAppConfig() {
		packages("com.spring.interview.controllers");
	}
}
