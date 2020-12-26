package com.ashokit.demo.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ashokit.demo.entity.City;
import com.ashokit.demo.entity.Country;
import com.ashokit.demo.entity.State;
import com.ashokit.demo.entity.User;
import com.ashokit.demo.repo.CityRepo;
import com.ashokit.demo.repo.CountryRepo;
import com.ashokit.demo.repo.StateRepo;
import com.ashokit.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	CountryRepo countryRepo;
	
	@Autowired
	StateRepo stateRepo;
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public Map<Integer, String> findCountries() {
		
		return countryRepo.findAll().stream().collect(Collectors.toMap(Country::getCountryId, Country::getCountryName));
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		
		return stateRepo.findByCountryId(countryId).stream().collect(Collectors.toMap(State::getStateId, State::getStateName));
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		
		return cityRepo.findByStateId(stateId).stream().collect(Collectors.toMap(City::getCityId, City::getCityName));
	}

	@Override
	public boolean isEmailUnique(String email) {
		
		User userByEmail = userRepo.findByEmail(email);
		
		return userByEmail.getUserId()==null;
	}

	@Override
	public String register(User user) {
		
		//Generate Password
		String generatePassword = "";
		
		//Insert into User table with the generated password
		user.setPassword(generatePassword);
		
		//Send Email
		
		
		return "Please check your email to unlock your account";
	}

	@Override
	public String signIn(String email, String password) {
		
		User userDetails = userRepo.findByEmailAndPassword(email, password);
		if(userDetails.getUserId()==null) {
			return "Invalid Credentials";
		} else if(userDetails.getAccntStatus().equalsIgnoreCase("Locked")) {
			return "Account Locked";
		} else {
			return "Welcome to Ashok IT!";
		}
	}

	@Override
	public String unlockAccount(String email, String newPassword, String tempPassword) {
		
		User userDetails = userRepo.findByEmail(email);
		
		if(userDetails.getAccntStatus().equalsIgnoreCase("UNLOCKED")) {
			return "This account is already unlocked";
		} else {
			userDetails.setPassword(newPassword);
			userDetails.setAccntStatus("UNLOCKED");
			
			//Update the account with new pwd and status
			
		}
		return "‘Account unlocked, please proceed with login";
	}

	@Override
	public String forgotPassword(String email) {
		
		User userDetails = userRepo.findByEmail(email);
		if(userDetails.getUserId()!= null) {
			String password = userDetails.getPassword();
			//send Email with Password
			
			return "Password has been sent to your email";
		} else {
			return "Email is not registered";
		}
	}

}
