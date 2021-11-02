package com.example.Greetings.service;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
}