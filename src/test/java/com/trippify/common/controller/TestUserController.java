package com.trippify.common.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trippify.TestWithSpringBoot;
import com.trippify.trippify.common.model.ConfigResponseBean;
import com.trippify.trippify.common.model.UserVO;

public class TestUserController extends TestWithSpringBoot {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objMapper;

	@Test
	void testRetrieveRegUsers() throws Exception {
		RequestBuilder requestBuilt = MockMvcRequestBuilders.get("/user/retrieveUsers")
				.contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(requestBuilt).andExpect(MockMvcResultMatchers.status().isOk());
		MvcResult mvcResult = this.mockMvc.perform(requestBuilt).andReturn();
		String json = mvcResult.getResponse().getContentAsString();
		ConfigResponseBean configResponseBean = objMapper.readValue(json, ConfigResponseBean.class);
		System.out.println(configResponseBean.getRegUsersList());

		List<UserVO> userVO = configResponseBean.getRegUsersList();
		boolean isUserExist = userVO.stream().anyMatch(user -> user.getUsername().equals("TESTUSER2"));
		assertEquals(userVO.size(), 3);
		assertTrue(isUserExist);
	}
}
