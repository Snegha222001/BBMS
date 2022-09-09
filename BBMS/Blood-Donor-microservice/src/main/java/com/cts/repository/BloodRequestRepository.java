package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.BloodRequest;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Integer> {

}
