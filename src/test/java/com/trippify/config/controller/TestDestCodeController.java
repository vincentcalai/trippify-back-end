package com.trippify.config.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trippify.TestWithSpringBoot;
import com.trippify.trippify.common.model.ConfigResponseBean;
import com.trippify.trippify.config.model.DestCodeViewVO;

public class TestDestCodeController extends TestWithSpringBoot {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objMapper;

	@Test
	@SuppressWarnings("unchecked")
	void testRetrieveCodeResult() throws Exception {
		RequestBuilder requestBuilt = MockMvcRequestBuilders.get("/code/retrieveDestCode")
				.contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(requestBuilt).andExpect(MockMvcResultMatchers.status().isOk());
		MvcResult mvcResult = this.mockMvc.perform(requestBuilt).andReturn();
		String json = mvcResult.getResponse().getContentAsString();
		ConfigResponseBean configResponseBean = objMapper.readValue(json, ConfigResponseBean.class);
		System.out.println(configResponseBean.getResult());

		Map<String, List<DestCodeViewVO>> destCodeMap = (Map<String, List<DestCodeViewVO>>) configResponseBean
				.getResult().get("cdTyp");

		List<DestCodeViewVO> destCodeList = objMapper.convertValue(destCodeMap.get("CD_DEST"),
				new TypeReference<List<DestCodeViewVO>>() {
				});
		System.out.println(destCodeList);
		boolean isCityFound = destCodeList.stream().anyMatch(dest -> dest.getId() == 2365
				&& dest.getCtry().equals("Australia") && dest.getCity().equals("Brisbane"));
		assertTrue(isCityFound);
	}
}
