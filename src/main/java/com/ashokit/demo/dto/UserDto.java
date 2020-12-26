package com.ashokit.demo.dto;

import java.util.Map;

public interface UserDto {
	
	public Map<Integer, String> findCountries();
	public Map<Integer, String> findStates();
	public Map<Integer, String> findCities();
	
//	public User getUserById(Integer id);
//	public User getUserByEmail(String email);
//	public boolean validateUser(String password);
//	public boolean updatePassword(String password);
//	public void setTempPassword(String tempPassword);
//	public boolean createUser(User user);
}
