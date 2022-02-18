package com.bridgelabs.greetingAppDevelopment.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.greetingAppDevelopment.model.Greeting;


@RestController
public class GreetingController {
	private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();
    
	@GetMapping("/")
	public String sayHello() {
		return "hello from bridgelabs";
	}

	@GetMapping("/greeting/{name}")
	public Greeting sayHelloByPathVar(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}

	@GetMapping("/body")
	public String sayHelloByBody(@RequestBody Greeting greeting) {
		return "hello  "+greeting.getContent()+"id is  "+greeting.getId() ;
	}
}
