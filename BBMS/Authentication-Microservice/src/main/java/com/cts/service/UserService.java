package com.cts.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Role;
import com.cts.model.User;
import com.cts.repository.RoleRepository;
import com.cts.repository.UserRepository;

@Service
public class UserService {
	
	
	Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
			
	
		
		  public User registerNewUser(String username,String password) 
		  {  
			 
			 
				  User user=new User();
				  Role role = roleRepo.findById(2).get(); 
				  Set<Role> userRoles = new HashSet<>();
			      userRoles.add(role);
			      user.setRole(userRoles);
			      user.setUsername(username);
			      user.setPassword(password);
			      
			      logger.info("New user registered");
			      return userRepo.save(user); 
			  
			  
		  }
		  
		
	
}
