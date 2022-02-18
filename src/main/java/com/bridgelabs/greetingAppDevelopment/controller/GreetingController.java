package com.bridgelabs.greetingAppDevelopment.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.greetingAppDevelopment.model.GreetedUser;
import com.bridgelabs.greetingAppDevelopment.model.Greeting;
import com.bridgelabs.greetingAppDevelopment.service.GreetingService;

@RestController
public class GreetingController {
	private static final String template = "Hello %s";
	private final AtomicInteger counter = new AtomicInteger();

	@Autowired
	GreetingService serve;

	@GetMapping("/")
	public String sayHello() {
		return "hello from bridgelabs";
	}

	@PostMapping("/greeting/{name}")
	public Greeting sayHelloByPathVar(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PutMapping("/body")
	public String sayHelloByBody(@RequestBody Greeting greeting) {
		return "hello  " + greeting.getContent() + "id is  " + greeting.getId();
	}
	 
	@GetMapping("/getServe")
	public String sayHelloByService() {
		return serve.getMessage();
	}
	@PostMapping("/getuser")
	public String sayHelloToUser(@RequestBody GreetedUser user) {
		return serve.getUser(user);
	}
	@PostMapping("/getuser/message")
	public String sayHelloToUserByRequestparam(@RequestParam(defaultValue="world") String firstName,@RequestParam(defaultValue="") String lastName) {
		return serve.getMessageByParam(firstName,lastName);
	}
	
	@PostMapping("/postToRepo")
	public void  postOnRepo(@RequestBody Greeting greet) {
	  serve.saveMessage(greet);
	 //return msg;
	}
}
