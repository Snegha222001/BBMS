package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
