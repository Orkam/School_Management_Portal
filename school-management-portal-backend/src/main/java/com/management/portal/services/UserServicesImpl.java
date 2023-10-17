/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 17 Oct 2023
*/
package com.management.portal.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.portal.Model.User;
import com.management.portal.Model.UserRol;
import com.management.portal.repository.RolRepository;
import com.management.portal.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolRepository rolRepository;

	@Override
	public User saveUser(User user, Set<UserRol> userRoles) throws Exception {

		User userDb = userRepository.findByUsername(user.getUsername());

		if (userDb != null) {

			throw new Exception("User already exist");

		} else {

			for (UserRol userRol : userRoles) {
				rolRepository.save(userRol.getRol());

			}

			user.getUserRols().addAll(userRoles);
			userDb = userRepository.save(user);
		}

		return userDb;
	}

}
