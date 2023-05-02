package com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.UserRepositoy;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepositoy userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("user 404");
		return new UserPrinciple(user);
	}

}
