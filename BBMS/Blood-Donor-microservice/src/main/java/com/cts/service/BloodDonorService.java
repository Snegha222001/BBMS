package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.BloodRequest;
import com.cts.model.DonorDetails;
import com.cts.repository.BloodRequestRepository;
import com.cts.repository.DonorDetailsRepository;

@Service
public class BloodDonorService {
	
	 Logger logger = LoggerFactory.getLogger(BloodDonorService.class);

	@Autowired
	private DonorDetailsRepository donorDetailsRepository;

	@Autowired
	private BloodRequestRepository bloodRequestRepository;

	// Update profile for donor
	public DonorDetails updateProfile(int id, DonorDetails donorDetails) throws Exception {
		Optional<DonorDetails> donor = donorDetailsRepository.findById(id);
		if (donor.isPresent()) {
			DonorDetails donorUpdate = donor.get();

			donorUpdate.setEmail(donorDetails.getEmail());
			donorUpdate.setBloodgroup(donorDetails.getBloodgroup());
			donorUpdate.setAge(donorDetails.getAge());
			donorUpdate.setMobilenumber(donorDetails.getMobilenumber());
			donorUpdate.setCountry(donorDetails.getCountry());
			donorUpdate.setState(donorDetails.getState());
			donorUpdate.setCity(donorDetails.getCity());
			donorUpdate.setArea(donorDetails.getArea());
			donorUpdate.setWeight(donorDetails.getWeight());
			
			donorUpdate.setGender(donorDetails.getGender());

			return donorDetailsRepository.save(donorUpdate);
		} else {
			throw new Exception("Not Found");
		}

	}

	public List<DonorDetails> getDonors() {
		
		logger.info("Donor Found");

		return donorDetailsRepository.findAll();
		
	}
	
	public List<DonorDetails> searchdonorbykeyword(String bloodgroup) {
		
		if(bloodgroup == "") {
			return donorDetailsRepository.findAll();
			
		}
		else {
			
			return donorDetailsRepository.findByBloodgroupOfDonor(bloodgroup);
			
		}
		
		
	}

	public DonorDetails registerDonor(DonorDetails donorDetails) {

     
     
     logger.info("Donor Registered Successfully");
		
		return donorDetailsRepository.save(donorDetails);
	}

	public DonorDetails getDonorsById(int id) {

		return donorDetailsRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Donor with id" + id + " does not exist"));
	}

	public List<BloodRequest> getBloodRequest() {
		
		
		logger.info("Request Received");

		return bloodRequestRepository.findAll();
	}

	public BloodRequest addBloodRequest(BloodRequest bloodRequest) {

		logger.info("Sending Blood Request");
		return bloodRequestRepository.save(bloodRequest);
	}

}
