/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 3 Nov 2023
*/
package com.management.portal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.management.portal.Model.User;
import com.management.portal.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByUsername(username);
		
		if(user==null) {
			
			throw new UsernameNotFoundException("User not found");
		}
		
		return user;
	}
	
	
	

}
