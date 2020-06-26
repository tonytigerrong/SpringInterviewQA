package com.spring.interview.jerseyconfigs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/jersey")
public class JerseyAppConfig extends ResourceConfig {
	public JerseyAppConfig() {
		packages("com.spring.interview.jerseycontrollers");
//		register(JerseyAppConfig.class);
	}
}
