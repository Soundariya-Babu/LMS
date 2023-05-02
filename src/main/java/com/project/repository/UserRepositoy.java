package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public interface UserRepositoy extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}
