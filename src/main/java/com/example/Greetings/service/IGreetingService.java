package com.example.Greetings.service;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.model.User;

import java.util.Optional;
public interface IGreetingService {
	Greeting addGreeting(User user);
	Optional<Greeting> getGreetingById(long id);
}