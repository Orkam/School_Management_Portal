/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 17 Oct 2023
*/
package com.management.portal.services;

import java.util.Set;

import com.management.portal.Model.User;
import com.management.portal.Model.UserRol;

public interface UserServices {
	
	public User saveUser(User user, Set<UserRol> userRoles)throws Exception;

}
