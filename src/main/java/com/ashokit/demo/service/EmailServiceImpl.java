package com.ashokit.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ashokit.demo.entity.User;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public boolean sendEmail(String to, String body, String subject) {
		
		try {
			MimeMessage mailMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setFrom("noreply@ies.com");
			
			mailSender.send(mailMessage);
			
			return true;
			
		} catch (MessagingException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getForgotPasswordBody(String email, String password) {
		
		return "The password for your ID: "+password;
	}

	@Override
	public String getUnlockEmailBody(User user, String tempPassword) {
		
		File unlkAccntEmail = new File("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.TXT");
		
		StringBuffer sb = new StringBuffer("");
		
		try {
			FileReader reader = new FileReader(unlkAccntEmail);
			
			BufferedReader br = new BufferedReader(reader);
			
			String line = br.readLine();
			
			while(line != null) {
				if(line.contains("{FNAME}")){
					line = line.replace("{FNAME}",user.getFirstName());
				}

				if(line.contains("{LNAME}")){
					line = line.replace("{LNAME}",user.getLastName());
				}
				
				if(line.contains("{TEMP-PWD}")){
				     line = line.replace("{TEMP-PWD}", user.getPassword());
				}

				if(line.contains("{EMAIL}")){
				     line = line.replace("{EMAIL}", user.getEmail());
				}

				sb.append(line);

				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return sb.toString();
	}

}
