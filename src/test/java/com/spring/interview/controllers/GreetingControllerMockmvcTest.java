package com.spring.interview.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.spring.interview.configs.TestServiceConfiguration;

@SpringBootTest
@AutoConfigureMockMvc
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest
//@ContextConfiguration(classes = TestServiceConfiguration.class) 
class GreetingControllerMockmvcTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test() {
		try {
			ResultActions rs1 = this.mockMvc.perform(get("/"));
			
			MvcResult result = rs1.andReturn();
			String body = result.getResponse().getContentAsString(); 
			System.out.println("****"+body);
			
			ResultActions rs2 = rs1.andDo(print());
			ResultActions rs3 = rs2.andExpect(status().isOk());
			ResultActions rs4 = rs3.andExpect(content().string(containsString("Hello")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
