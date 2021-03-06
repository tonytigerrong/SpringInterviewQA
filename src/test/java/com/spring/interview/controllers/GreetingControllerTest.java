package com.spring.interview.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
		
	/**
	 * integrate test for http get method
	 * http://localhost:8080/greeting?name=
	 * @throws URISyntaxException 
	 */
	@Test
	void testByTemplateExchange() throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpMethod method = HttpMethod.GET;
		
		HttpEntity<String> request = new HttpEntity(null, (MultiValueMap) headers);
		String url = "http://localhost:" + this.port + "/greeting?name=tony";
		URI uri = new URI(url);
		

		//post request to URI
		ResponseEntity<String> response = this.restTemplate.exchange(uri, method, request,String.class);
		String body = response.getBody();
		System.out.println(body);
		Assertions.assertTrue(body.indexOf("Hello")>0);
		Assertions.assertTrue(body.indexOf("<html>")>0);
	}
	
	/**
	 * integrate test for http get method
	 * http://localhost:8080/greeting?name=
	 * @throws URISyntaxException
	 */
	@Test
	void testByTemplateGetForObject() throws URISyntaxException {
		String url = "http://localhost:" + this.port + "/greeting?name=tony";
		this.restTemplate.getForObject(url , String.class).contains("Hello");
	}

}
