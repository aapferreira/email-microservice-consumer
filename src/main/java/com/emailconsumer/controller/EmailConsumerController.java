package com.emailconsumer.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmailConsumerController {
	
	@RequestMapping("/hello")
	public String Hello() {
		return "Hello";
	}

	@RequestMapping("/chamahellomesmaaplicacao")
	public String getHelloClient() {
		String uri = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@RequestMapping("/chamatodosemails8081comostring")
	public String getAllEmailsString() {
		String uri = "http://localhost:8081/emails";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@RequestMapping("/chamatodosemails8081comoarray")
	public List<Object> getAllEmailsArray() {
		String uri = "http://localhost:8081/emails";
		RestTemplate restTemplate = new RestTemplate();
		Object[] result = restTemplate.getForObject(uri, Object[].class);
		return Arrays.asList(result);
	}
	
	public void setEmailViaBackEnd() {
		String uri = "http://localhost:8081/sending-email";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> map = new HashMap<>();
		map.put("ownerRef", "ownerRef cons" + new Date());
		map.put("emailFrom", "emailFromCons@gmail.com");
		map.put("emailTo", "emailToCons@gmail.com");
		map.put("subject", "subject cons" + new Date());
		map.put("text", "text cons" + new Date());

		ResponseEntity<Void> response = restTemplate.postForEntity(uri, map, Void.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
		    System.out.println("Request Successful");
		} else {
		    System.out.println("Request Failed");
		}		
		
	}
	
}
