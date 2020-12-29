package com.ashokit.demo.service;

import com.ashokit.demo.entity.User;

public interface EmailService {
	
	public String sendUnlockEmail(User user, String tempPassword);
	public String sendForgotPasswordEmail(String email, String password);
}
