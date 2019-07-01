package com.michael.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.michael.AdService1ApplicationTests;
import com.michael.beans.DAO.noSql.Advertisment;
import com.michael.beans.DAO.noSql.AdvertismentRepository;
import com.michael.beans.api.GetAdRequest;
import com.michael.service.impl.AdServiceImpl;

//@RunWith(SpringRunner.class)
//@WebMvcTest(ApiController.class)
//@ContextConfiguration(classes={AdService1ApplicationTests.class})
////@EntityScan(basePackages = { "com.michael.beans.DAO.noSql" })
//@EnableMongoRepositories(basePackages = { "com.michael.beans.DAO.noSql" })
public class ApiControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private AdvertismentRepository adervtismentRepository;
//	
	@MockBean
	private AdServiceImpl adServiceImpl;

//	@MockBean
//	private Utils utils;
	
//	@MockBean
//	SystemConfig systemConfig;
	
	@Before
	public void setUp() throws Exception {
	}
    @Test
	public void test() {
//		success();
	}
	
//	@Test
	public void integrationtest() throws Exception {
		when(adServiceImpl.getAdToUser(ArgumentMatchers.any(String.class))).thenReturn(new Advertisment());
		Gson gson = new Gson();
	    String jsonStr = gson.toJson(new GetAdRequest("b8143b3a-4815-47aa-8b10-8086d3330ade")); // no matter what the pwd is , always get a empty PwdValidationResponse()
	    
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/getAD")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr);
	    
	    mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$.data").exists())
        .andExpect(jsonPath("$.data.title").exists())
        .andExpect(jsonPath("$.data.url").exists())
        .andExpect(jsonPath("$.data.capWindowMin").exists())
        .andExpect(jsonPath("$.status").exists());
	}

}
