package com.bridgelabs.greetingAppDevelopment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {
	@Id
	@GeneratedValue
	private Integer id;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Greeting(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Greeting() {

	}

	public Greeting(Greeting greet) {
		this.content = greet.content;
	}
}
