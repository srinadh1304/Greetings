package com.example.Greetings.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Greetings.model.Greeting;


public interface GreetingRepository extends JpaRepository<Greeting, Long>{

}