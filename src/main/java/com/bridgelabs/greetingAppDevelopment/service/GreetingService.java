package com.bridgelabs.greetingAppDevelopment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabs.greetingAppDevelopment.model.GreetedUser;
import com.bridgelabs.greetingAppDevelopment.model.Greeting;
import com.bridgelabs.greetingAppDevelopment.repository.GreetingRepoInterface;

@Service
public class GreetingService {
	@Autowired
	GreetingRepoInterface repo;
    
	//getting simple helloWorld msg
	public String getMessage() {

		return "hello world";
	}
	
	//
	public String getUser(GreetedUser user) {

		return "hello " + user.getFirstName() + " " + user.getLastName();
	}

	public String getMessageByParam(String firstName, String lastName) {
		if (firstName == "world" && lastName != null)
			return "hello " + lastName;
		else
			return "hello " + firstName + " " + lastName;
	}

	public String saveMessage(Greeting greet) {
		Greeting newGreeting = new Greeting(greet);
		repo.save(newGreeting);
		return "Sucussed";
	}

	public String getDataFromRepo(Integer id) {
		Greeting greetObj = repo.getById(id);
		String output = greetObj.getContent();
		return output;
	}

	public List<Greeting> findAll() {
		List<Greeting> greetList = repo.findAll();
		return greetList;
	}

	public String deleteByID(int id) {
		repo.deleteById(id);
		return "deletion of greeting user with id "+id+" is sucussesfull";
	}

}
