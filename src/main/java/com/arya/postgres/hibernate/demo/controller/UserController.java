package com.arya.postgres.hibernate.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arya.postgres.hibernate.demo.entity.UserEntity;
import com.arya.postgres.hibernate.demo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired private UserRepository repository;
	
	
	@GetMapping("/")
	public List<UserEntity> findAll() {
		return repository.findAll();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> findById(@PathVariable Integer id) {
		
		Optional<UserEntity> user = repository.findById(id);
		if(user.isPresent())
			return ResponseEntity.ok(user.get());
		
		throw new RuntimeException("No user found for Id: " + id);
		
	}
	
	
}
