//package com.cts.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.when;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cts.model.Role;
//import com.cts.model.User;
//import com.cts.repository.RoleRepository;
//import com.cts.repository.UserRepository;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class UserServiceTest {
//	
//	
//	
//	@MockBean 
//	private UserRepository userRepo;
//	
//	@MockBean 
//	private RoleRepository roleRepo;
//	
//	@Autowired
//	private UserService service;
//	
//
//	@Test
//	public void registerNewUserTest() {
//		Role userRole = new Role();
//	     userRole.setRoleId(2);
//	     userRole.setRoleName("USER");
//	     User user = new User();
//	     user.setUsername("Snegha");
//	     user.setPassword("abc");
//	     Set<Role> userRoles = new HashSet<>();
//	     userRoles.add(userRole);
//	     user.setRole(userRoles);
//	     doReturn(Optional.of(userRole)).when(roleRepo).findById(2);	     
//	     when(userRepo.save(user)).thenReturn(user);
//	     User registerNewUser = service.registerNewUser("Snegha","abc");
//	     assertEquals(user,registerNewUser);
//		
//	}
//
//}
