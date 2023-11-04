/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 17 Oct 2023
*/
package com.management.portal.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="userRol")
public class UserRol {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRolId;
	
	@ManyToOne(fetch= FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Rol rol;
	
	

	public UserRol() {
		super();
	}

	public Long getUserRolId() {
		return userRolId;
	}

	public void setUserRolId(Long userRolId) {
		this.userRolId = userRolId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

}
