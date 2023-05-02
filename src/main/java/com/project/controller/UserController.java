package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.service.UserService;
import com.project.service.UserServiceInterface;

@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;

//	@GetMapping("/hello")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<String> loginmethod(){
//		return new ResponseEntity<String>("Hi you are successfully logged in", HttpStatus.OK);
//	}
	
	@PostMapping("/add")
	public ResponseEntity<String> newUser(@RequestBody User user)
	{
		  userService.addNewUser(user);
		  return new ResponseEntity<String>("Hi you are successfully logged in", HttpStatus.OK);
		  
		
	}
}