package com.formHandling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formHandling.backend.entity.User;
import com.formHandling.backend.exception.ResourceNotFoundException;
import com.formHandling.backend.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:3000/")  //Access to backend from frontend was blocked via CORS Policy
@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	//get all users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	//create user api
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		//RequestBody: is used because User will return a json type object
		//to map it to User type(Java type object)
		return userRepository.save(user);
		//While hitting postman ensure content-type should be application/json
	}
	//get user by id rest api
	//Here, ResponseEntity generic type is used because we are dealing with http responses
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not exist with id:" + id));
		return ResponseEntity.ok(user);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails){
		User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not exist with id:" + id));
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setMobilenumber(userDetails.getMobilenumber());
		user.setState(userDetails.getState());
		user.setGender(userDetails.getGender());
		user.setSkills(userDetails.getSkills());
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
		
	}

}
