package com.ashokit.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.demo.entity.User;
import com.ashokit.demo.service.UserService;

@RestController
public class RegisterRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/countries")
	public Map<Integer, String> getCountires(){
		return userService.findCountries();
	}
	
	@GetMapping("/states/{countryId}")
	public Map<Integer, String> getStates(@PathVariable("countryId") Integer countryId){
		return userService.findStates(countryId);
	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer, String> getCities(@PathVariable("stateId") Integer stateId){
		return userService.findCities(stateId);
	}
	
	@GetMapping("/isEmailUnique/{email}")
	public boolean isEmailUnique(@PathVariable("email") String email) {
		
		return userService.isEmailUnique(email);
	}
	
	@PostMapping("/register")
	public String signUp(@RequestBody User user) {
		return userService.register(user);
	}
}
