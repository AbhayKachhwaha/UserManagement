package com.ashokit.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ashokit.demo.entity.User;
import com.ashokit.demo.repo.UserRepo;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	
	@MockBean
	UserRepo userRepo;
	
	@MockBean
	EmailService emailService;
	
	@InjectMocks
	UserServiceImpl service;
	
	@Test
	public void test_1_isEmailUnique() {
		
		String email = "dummy@email.com";
		
		User user = new User(email, "123");
		
		when(userRepo.findByEmail(email)).thenReturn(user);
		
		boolean result = service.isEmailUnique(email);
		
		assertEquals(false, result);
	}
	
	@Test
	public void test_2_register() {
		
		User user = new User();
		
		when(userRepo.save(user)).thenReturn(user);
		
		when(emailService.getUnlockEmailBody(user, "1234")).thenReturn("some body text");
		
		when(emailService.sendEmail(user.getEmail(), "some body text", "subject")).thenReturn(true);
		
		String result = service.register(user);
		
		assertEquals("registerSucc", result);
	}
	
	@Test
	public void test_3_signIn() {
		
		User user = new User("dummy@email.com", "1234");
		user.setAccntStatus("Unlocked");
		
		when(userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(user);
		
		String result = service.signIn(user.getEmail(), user.getPassword());
		
		assertEquals("succMsg", result);
	}
	
	@Test
	public void test_4_unlockAccnt() {
		
		User user = new User("dummy@email.com", "1234");
		user.setAccntStatus("");
		user.setPassword("123");
		
		when(userRepo.findByEmail(user.getEmail())).thenReturn(user);
		
		String result = service.unlockAccount(user.getEmail(), "NewPass", user.getPassword());
		
		assertEquals("accntUnlkSucc", result);
	}
	
	@Test
	public void test_5_forgotPassword() {
		
		User user = new User("dummy@email.com", "1234");
		user.setAccntStatus("");
		user.setPassword("123");
		
		when(userRepo.findByEmail(user.getEmail())).thenReturn(user);
		when(emailService.getForgotPasswordBody(user.getEmail(), user.getPassword())).thenReturn("forgot password body");
		when(emailService.sendEmail(user.getEmail(), "some body text", "subject")).thenReturn(true);
		
		String result = service.forgotPassword(user.getEmail());
		
		assertEquals("frgtPassSucc", result);
	}
}
