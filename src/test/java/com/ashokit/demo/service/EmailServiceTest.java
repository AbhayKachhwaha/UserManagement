package com.ashokit.demo.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class EmailServiceTest {

	@MockBean
	JavaMailSender mailSender;
}
