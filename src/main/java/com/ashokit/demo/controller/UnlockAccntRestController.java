package com.ashokit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.demo.service.UserService;

@RestController
public class UnlockAccntRestController {
	
	@Autowired
	UserService userService;
	
	/*
	 * @GetMapping("/unlockAcc/{email}") public String
	 * unlockAccount(@PathVariable("email") String email) {
	 * 
	 * 
	 * 
	 * return null; }
	 */
	
	@PostMapping("/unlockAcc/{email}")
	public String unlockUserAccnt(@PathVariable String email, @RequestParam("j_tempPwd") String tempPwd, @RequestParam("j_newPwd") String newPwd) {
		
		return userService.unlockAccount(email, newPwd, tempPwd);
	}
	
}
