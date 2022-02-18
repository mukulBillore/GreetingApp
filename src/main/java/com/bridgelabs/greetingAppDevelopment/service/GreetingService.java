package com.bridgelabs.greetingAppDevelopment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabs.greetingAppDevelopment.model.GreetedUser;

@Service
public class GreetingService {


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
	
}
