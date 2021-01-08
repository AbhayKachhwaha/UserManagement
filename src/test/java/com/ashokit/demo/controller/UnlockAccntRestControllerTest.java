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

import com.ashokit.demo.entity.UnlockAccount;
import com.ashokit.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = UnlockAccntRestController.class)
public class UnlockAccntRestControllerTest {
	
	@MockBean
	UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test_1_unlockAccnt() throws Exception {
		
		String email = "dummy@email.com";
		String newPwd = "Abc123";
		String tempPwd = "temp123T";
		
		UnlockAccount bind = new UnlockAccount(email, tempPwd, newPwd);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bind);
		
		when(userService.unlockAccount(email, newPwd, tempPwd)).thenReturn("Please check your email to unlock your account");
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/unlockAcc").contentType("application/json").content(json);
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		
		assertEquals(202, mvcResult.getResponse().getStatus());
	}
}
