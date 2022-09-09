package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.DonorDetails;

@Repository
public interface DonorDetailsRepository extends JpaRepository<DonorDetails,Integer> {

	@Query("select s from DonorDetails s where s.bloodgroup = ?1")
	public List<DonorDetails> findByBloodgroupOfDonor(String bloodgroup);
	
}
