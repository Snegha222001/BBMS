package com.cts.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.AuthorizingClient;
import com.cts.model.BloodRequest;
import com.cts.model.DonorDetails;
import com.cts.repository.BloodRequestRepository;
import com.cts.repository.DonorDetailsRepository;
import com.cts.service.BloodDonorService;



@RestController
@RequestMapping("/donor")
@CrossOrigin(origins="http://localhost:3000")
public class BloodDonorController {
	
	@Autowired
	private BloodDonorService bloodDonorService;

	@Autowired
	private AuthorizingClient client;

	


	@GetMapping
	public List<DonorDetails> getDonors(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {
		if (client.authorizeTheRequestforUser(requestTokenHeader)) {
			return bloodDonorService.getDonors();
		} else {
			throw new Exception("Not Allowed");
		}
	}

	@GetMapping("/{id}")
	public DonorDetails getDonorsById(@PathVariable int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {
		if (client.authorizeTheRequestforUser(requestTokenHeader)) {
			return bloodDonorService.getDonorsById(id);
		} else {
			throw new Exception("Not Allowed");
		}

	}

	@PostMapping("/register")
	public DonorDetails registerDonor(@RequestBody DonorDetails donorDetails) throws Exception {

		client.registerNewUser(donorDetails);
		return bloodDonorService.registerDonor(donorDetails);

	}

	@PostMapping("/addBloodRequest")
	public BloodRequest addBloodRequest(@RequestBody BloodRequest bloodRequest,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {
		if (client.authorizeTheRequestforAdmin(requestTokenHeader)) {
			return bloodDonorService.addBloodRequest(bloodRequest);
		} else {
			throw new Exception("Not Allowed");
		}
	}
	
	@GetMapping("/searchDonor")
	public List<DonorDetails> searchdonorbykeyword(@RequestParam String bloodgroup,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception{
		if (client.authorizeTheRequestforAdmin(requestTokenHeader)) {
			return bloodDonorService.searchdonorbykeyword(bloodgroup);
		} else {
			throw new Exception("Not Allowed");
		}
	}

	@PutMapping("/update/{id}")
	public DonorDetails updateProfile(@PathVariable int id, @RequestBody DonorDetails donorDetails,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {
		if (client.authorizeTheRequestforUser(requestTokenHeader)) {

			System.out.println(donorDetails);

			return bloodDonorService.updateProfile(id, donorDetails);
		} else {
			throw new Exception("Not Allowed");
		}

	}

	@GetMapping("/viewRequests")
	public List<BloodRequest> viewBloodRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception {
		if (client.authorizeTheRequestforUser(requestTokenHeader)) {
			return bloodDonorService.getBloodRequest();
		} else {
			throw new Exception("Not Allowed");
		}
	}

}
