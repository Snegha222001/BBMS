package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RoleController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping(value = "/validateUser")
	@PreAuthorize("hasRole('ROLE_USER')")
	public boolean authorizeTheRequestforUser(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
		String jwtToken = null;
		String userName = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				userName = jwtUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException | ExpiredJwtException e) {
				return false;
			}
		}
		return userName != null;

	}
	@PostMapping(value = "/validateAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean authorizeTheRequestforAdmin(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
		String jwtToken = null;
		String userName = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				userName = jwtUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException | ExpiredJwtException e) {
				return false;
			}
		}
		return userName != null;

	}
}
