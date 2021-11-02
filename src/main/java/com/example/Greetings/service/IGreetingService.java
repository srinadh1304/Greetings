package com.example.Greetings.service;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.model.User;

import java.util.List;
import java.util.Optional;
public interface IGreetingService {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getGreetings();
	Greeting editGreeting(String name1,String name2);
	List<Greeting> deleteGreeting(String name);

}