package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		return ResponseEntity.ok().body(user);		
	}
	
}
