package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.DonorDetails;
import com.cts.model.User;
import com.cts.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody DonorDetails donorDetails) {
		
		return userService.registerNewUser(donorDetails.getName(), donorDetails.getPassword());
	}

}
