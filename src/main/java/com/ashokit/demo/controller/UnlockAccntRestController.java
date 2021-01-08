package com.ashokit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.demo.config.AppPropertiesConfig;
import com.ashokit.demo.entity.UnlockAccount;
import com.ashokit.demo.service.UserService;

@RestController
public class UnlockAccntRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private AppPropertiesConfig prop;
	
	@PostMapping("/unlockAcc")
	public ResponseEntity<String> unlockUserAccnt(@RequestBody UnlockAccount unlkAcc) {
		
		String msgCode = userService.unlockAccount(unlkAcc.getEmail(), unlkAcc.getNewPassword(), unlkAcc.getTempPassword());
		
		return new ResponseEntity<String>(prop.getMessages().get(msgCode), HttpStatus.ACCEPTED);
	}
	
}
