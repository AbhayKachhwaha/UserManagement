package com.ashokit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.demo.config.AppPropertiesConfig;
import com.ashokit.demo.entity.User;
import com.ashokit.demo.service.UserService;

@RestController
public class LoginRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private AppPropertiesConfig appProp;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(Model model, @RequestBody User user) {
		
		String msgCode = userService.signIn(user.getEmail(), user.getPassword());
//		if(msg.equals("Welcome to Ashok IT!"))
			return new ResponseEntity<>(appProp.getMessages().get(msgCode), HttpStatus.OK);
//		else
//			return new ResponseEntity<>(msg, HttpStatus.EXPECTATION_FAILED);
	}
}
