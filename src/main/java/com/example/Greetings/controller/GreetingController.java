package com.example.Greetings.controller;

import java.util.concurrent.atomic.AtomicLong;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	 
	 @PostMapping("/postGreeting")
	    public Greeting sayHello(@RequestBody Greeting greeting){
	        return new Greeting(counter.incrementAndGet(),String.format(template,greeting.getContent()));
	 }
	 
	 @PutMapping("/putGreeting/{counter}")
	    public Greeting sayHello(@PathVariable int counter,@RequestParam(value = "content")String contentName){
	        return new Greeting(counter,String.format(template,contentName));
	 }
	 @GetMapping(value = "/getGreetingByID")
		public ResponseEntity<String> getEmployeeByID(@RequestParam(name = "id") int id) {
			return new ResponseEntity(greetingService.getGreetingById(id), HttpStatus.OK);
		}
	 @GetMapping(value = "/getgreetings")
		public ResponseEntity<String> getGreetings() {
			return new ResponseEntity(greetingService.getGreetings(), HttpStatus.OK);
	}

	 
}