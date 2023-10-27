/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 17 Oct 2023
*/
package com.management.portal.Controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.portal.Model.Rol;
import com.management.portal.Model.User;
import com.management.portal.Model.UserRol;
import com.management.portal.services.UserServices;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200/")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/saveUser")
	public void saveUser(@RequestBody User user) throws Exception {
		
		Set<UserRol>roles = new HashSet<>();
		
		Rol rol = new Rol();
		
		rol.setId(1L);
		rol.setName("NORMAL");
		
		UserRol userRol = new UserRol();
		
		userRol.setRol(rol);
		userRol.setUser(user);
		
		roles.add(userRol);
		
		userServices.saveUser(user, roles);
		

	}
	
	@GetMapping({"","/"})
	public void home() 
	
	{}
	
	@GetMapping("login")
	public void login() 
	
	{}
	
	@GetMapping("signup")
	public void signup() 
	
	{}

}
