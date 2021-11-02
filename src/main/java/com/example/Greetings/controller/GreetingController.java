package com.example.Greetings.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.model.User;
import com.example.Greetings.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private IGreetingService greetingService;
	
	 @GetMapping(value = {"","/","/home"})
	 public Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name){
	        User user = new User();
	        user.setFirstName(name);
	        return greetingService.addGreeting(user);
	 }

	 
	 @GetMapping(value = {"/greetingid"})
	    public Greeting getGreetingByID(@RequestParam(value="id",defaultValue="World") long id)
	    {
	        return greetingService.getGreetingById(id);
	    }
	    
	    @GetMapping("/greetinglist")
	    public List<Greeting> getGreetingList()
	    {
	    	return greetingService.getGreetings();
	    }
	    
	    @PutMapping("/update/{name1}/{name2}")
	    public Greeting editGreeting(@PathVariable String name1, @PathVariable String name2)
		{
	        return greetingService.editGreeting(name1, name2);
	    }

	    @PutMapping("put/{name}")
	    public Greeting sayHello(@PathVariable String name)
		{
	        return new Greeting(counter.incrementAndGet(),String.format(template, name));
	    }
	 
}