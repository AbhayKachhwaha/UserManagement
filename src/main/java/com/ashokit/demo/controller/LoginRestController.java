package com.ashokit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.demo.entity.User;
import com.ashokit.demo.service.UserService;

@RestController
public class LoginRestController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		
		String msg = userService.signIn(user.getEmail(), user.getPassword());
		return msg;
	}
}
