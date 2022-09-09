package com.cts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.model.Role;
import com.cts.model.User;
import com.cts.service.JwtUserDetailsService;
import com.cts.util.JwtUtil;

@SpringBootTest
@AutoConfigureMockMvc
class RoleControllerTest {

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private JwtUserDetailsService userDetailsService;

	@MockBean
	private JwtUtil jwtTokenUtil;

	@MockBean
	private AuthenticationManager authenticationManager;

	@Test
	void testValidateUserEndpoint() throws Exception {
		this.mockMvc.perform(post("/validateUser")).andExpect(status().isUnauthorized());
	}

	@Test
	void testValidateAdminEndpoint() throws Exception {
		this.mockMvc.perform(post("/validateAdmin")).andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser(authorities = "ROLE_ADMIN")
	void textExistingUserAuthorize() throws Exception

	{
		Role adminRole = new Role();
		adminRole.setRoleId(1);
		adminRole.setRoleName("ADMIN");

		Role userRole = new Role();
		userRole.setRoleId(2);
		userRole.setRoleName("USER");

		User user = new User();
		user.setUsername("admin");
		user.setPassword("pass");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		user.setRole(adminRoles);

		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
		when(jwtTokenUtil.getUsernameFromToken("token")).thenReturn("admin");
		mockMvc.perform(MockMvcRequestBuilders.post("/validateAdmin").header("Authorization", "Bearer token"))
				.andExpect(status().isOk());

	}

	@Test
	@WithMockUser(authorities = "ROLE_ADMIN")
	void textNullTokenAuthorize() throws Exception {
		Role adminRole = new Role();
		adminRole.setRoleId(1);
		adminRole.setRoleName("ADMIN");

		Role userRole = new Role();
		userRole.setRoleId(2);
		userRole.setRoleName("USER");

		User user = new User();
		user.setUsername("admin");
		user.setPassword("pass");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		user.setRole(adminRoles);

		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
		when(jwtTokenUtil.getUsernameFromToken("token")).thenReturn("admin");
		mockMvc.perform(MockMvcRequestBuilders.post("/validateAdmin").header("Authorization", "")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}
