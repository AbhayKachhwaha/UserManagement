package com.ashokit.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.ashokit.demo.entity.User;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public String sendUnlockEmail(User user, String tempPassword) {
		
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
			
			return sb.toString();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return "Check your email to unlock your account.";
	}

	@Override
	public String sendForgotPasswordEmail(String email, String password) {
		
		return null;
	}

}
