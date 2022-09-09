package com.cts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.AuthorizingClient;
import com.cts.feign.BloodDonorClient;
import com.cts.model.BloodRequest;
import com.cts.model.DonorDetails;
import com.cts.service.HospitalService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/hospital")
public class HospitalController {
	
	Logger logger = LoggerFactory.getLogger(HospitalController.class);
	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private AuthorizingClient client;
	
	@Autowired
	private BloodDonorClient donorclient;

	@PostMapping("/sendBloodRequest")
	public BloodRequest sendBloodRequest(@RequestBody BloodRequest bloodRequest,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)throws Exception {

		// client.registerNewUser(donorDetails);
		if (client.authorizeTheRequestforAdmin(requestTokenHeader)) {
			donorclient.addBloodRequest(bloodRequest, requestTokenHeader);
			return hospitalService.sendBloodRequest(bloodRequest);

			
		} else {
			throw new Exception("Not Allowed");
		}
		
	}
	
	@GetMapping("/searchDonor")
	public List<DonorDetails> searchDonor(@RequestParam String bloodgroup,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)throws Exception{
		if (client.authorizeTheRequestforAdmin(requestTokenHeader)) {
			
			return donorclient.searchdonorbykeyword(bloodgroup,requestTokenHeader);
			
			
		} else {
			throw new Exception("Not Allowed");
		}
	}
	
	

}
