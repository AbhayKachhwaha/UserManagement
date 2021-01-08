package com.ashokit.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.demo.config.AppPropertiesConfig;
import com.ashokit.demo.entity.User;
import com.ashokit.demo.service.UserService;

@RestController
public class RegisterRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private AppPropertiesConfig props;
	
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
	public ResponseEntity<Boolean> isEmailUnique(@PathVariable("email") String email) {
		boolean isEmailUnique = userService.isEmailUnique(email);
		
		if(isEmailUnique) {
			return new ResponseEntity<Boolean>(isEmailUnique, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isEmailUnique, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		
		String msgCode = userService.register(user);
		return new ResponseEntity<>(props.getMessages().get(msgCode), HttpStatus.CREATED);
	}
}
