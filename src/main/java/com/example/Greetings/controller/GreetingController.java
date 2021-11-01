package com.example.Greetings.controller;

import java.util.concurrent.atomic.AtomicLong;

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

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	 @GetMapping("/greeting")
	    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name){
	        return new Greeting(counter.incrementAndGet(),String.format(template,name));
	 }
	 @RequestMapping(value= {"/query"}, method = RequestMethod.GET)
		public String sayHello(@RequestParam(value="name") String name) {
			return "Hello "+name;
		}
		
	 
	 @PostMapping("/post")
	    public Greeting sayHello(@RequestBody Greeting greeting){
	        return new Greeting(counter.incrementAndGet(),String.format(template,greeting.getContent()));
	 }
	 
	 @PutMapping("/put/{counter}")
	    public Greeting sayHello(@PathVariable int counter,@RequestParam(value = "content")String contentName){
	        return new Greeting(counter,String.format(template,contentName));
	    }
	 
}