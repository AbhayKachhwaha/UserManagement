package com.ashokit.demo.service;

import com.ashokit.demo.entity.User;

public interface EmailService {
	
	public boolean sendEmail(String to, String body, String subject);
	public String getForgotPasswordBody(String email, String password);
	public String getUnlockEmailBody(User user, String tempPassword);
}
