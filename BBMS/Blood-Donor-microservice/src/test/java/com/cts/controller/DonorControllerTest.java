package com.cts.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.service.BloodDonorService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DonorControllerTest {

		@SuppressWarnings("deprecation")
		@BeforeEach
		public void init() {
			MockitoAnnotations.initMocks(this);
		}
		
		
		

		

		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private BloodDonorService donorService;
		
		@MockBean
		private BloodDonorController donorController;

		

	
		@Test
		void testRandomUrl() throws Exception {
			this.mockMvc.perform(get("/other/url")).andExpect(status().isNotFound());
		}
		
		@Test
		void testPostUrl() throws Exception {
			this.mockMvc.perform(post("/other/url")).andExpect(status().isNotFound());
		}
		
		@Test
		void testPutUrl() throws Exception {
			this.mockMvc.perform(put("/other/url")).andExpect(status().isNotFound());
		}
		

}



