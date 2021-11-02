package com.example.Greetings.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GREETINGS")
public class Greeting {
	
	@Id
	private long id;
	private String content;
	
	public Greeting() {
		
		this.id = 0;
		this.content = "";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	
}