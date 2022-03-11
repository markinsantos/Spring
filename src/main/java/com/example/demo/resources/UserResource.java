package com.example.demo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.User;
import com.example.demo.service.UserService;



@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> listaUsuarios = service.findAll();
		return ResponseEntity.ok().body(listaUsuarios);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);
		
	}
	
}
