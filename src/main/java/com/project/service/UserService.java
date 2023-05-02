package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.UserRepositoy;


@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UserRepositoy userRepository;
	
	public String addNewUser(User user) {
		
		//User user1=new User();
		// user1.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
		 user.setPassword(passwordEncoder(user.getPassword()));
		 userRepository.save(user);
		 return "Added Successfully";
	}
	
	public String passwordEncoder( String password)
	{
		return new BCryptPasswordEncoder().encode(password);
	}
	
	
	

}
