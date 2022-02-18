package com.bridgelabs.greetingAppDevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabs.greetingAppDevelopment.model.Greeting;

public interface GreetingRepoInterface extends JpaRepository<Greeting, Integer> {};