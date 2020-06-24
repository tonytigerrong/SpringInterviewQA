package com.spring.interview.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.spring.interview.services.GreetingService;

@WebMvcTest
@ComponentScan(basePackages = {"com.spring.interview"})
class GreetingControllerWebMvcTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	GreetingService greetingService;
	
	
	@Test
	void test() {
		when(greetingService.greet()).thenReturn("Hello Mock");
		try {
			ResultActions rs = this.mockMvc.perform(get("/")).andExpect(status().isOk());
			rs.andExpect(content().string(containsString("Hello Mock")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
