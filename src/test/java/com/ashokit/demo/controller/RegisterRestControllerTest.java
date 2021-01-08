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

@WebMvcTest(value=RegisterRestController.class)
public class RegisterRestControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	@Test
	public void test_1_uniqueEmail() throws Exception {
		
		String email = "dummy@email.com";
		
		when(userService.isEmailUnique(email)).thenReturn(true);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/isEmailUnique/"+email);
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	@Test
	public void test_2_register() throws Exception {
		User user = new User();
		
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);
		
		when(userService.register(user)).thenReturn("Please check your email to unlock your account");
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/register").contentType("application/json").content(userJson);
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		
		assertEquals(201, mvcResult.getResponse().getStatus());
	}
	
	
}
