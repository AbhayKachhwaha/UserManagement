package com.ashokit.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
}
