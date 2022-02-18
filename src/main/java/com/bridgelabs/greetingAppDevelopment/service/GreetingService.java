package com.bridgelabs.greetingAppDevelopment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabs.greetingAppDevelopment.model.GreetedUser;
import com.bridgelabs.greetingAppDevelopment.model.Greeting;
import com.bridgelabs.greetingAppDevelopment.repository.GreetingRepoInterface;

@Service
public class GreetingService {
@Autowired
GreetingRepoInterface repo;

	public String getMessage() {
		
		return "hello world";
	}

	public String getUser(GreetedUser user) {
		
		return "hello "+user.getFirstName()+" "+user.getLastName();
	}

	public String getMessageByParam(String firstName, String lastName) {
		if(firstName=="world"&&lastName!=null)
		return "hello " +lastName;
		else 
			return "hello " +firstName+" "+lastName;
	}

	public void  saveMessage(Greeting greet) {
		Greeting newGreeting = new Greeting(greet);
		repo.save(newGreeting);
		//return "Sucussed";
	}
	
}
