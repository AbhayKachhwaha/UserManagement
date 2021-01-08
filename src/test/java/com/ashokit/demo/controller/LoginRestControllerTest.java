package com.ashokit.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashokit.demo.entity.User;
import com.ashokit.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = LoginRestController.class)
public class LoginRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void test_1_login() throws Exception {
		
		User login = new User("mock@email.com", "1234abc");
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(login);
		
		when(userService.signIn(login.getEmail(), login.getPassword())).thenReturn("Welcome to Ashok IT!");
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/login").contentType("application/json").content(json);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
	}
}
