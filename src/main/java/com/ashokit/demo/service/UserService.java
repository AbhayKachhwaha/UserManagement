package com.ashokit.demo.service;

import java.util.Map;

import com.ashokit.demo.entity.User;

public interface UserService {
	
	//Registration Page Operations
	public Map<Integer, String> findCountries();
	public Map<Integer, String> findStates(Integer countryId);
	public Map<Integer, String> findCities(Integer stateId);
	public boolean isEmailUnique(String email);
	public String register(User user);
	
	//Login Page Operations
	public String signIn(String email, String password);
	
	//////////////
//	public String generatePassword(User user);
//	public String sendUnlockEmail(String email, String generatedPassword);
//	
//	public String forgotPassword(String email);
//	public void sendForgotPasswordEmail(String email);
	/////////////
	
	//Unlock Accnt Operations
	public String unlockAccount(String email, String newPassword, String tempPassword);
	
	//Forgot Password Operations
	public String forgotPassword(String email);
}
