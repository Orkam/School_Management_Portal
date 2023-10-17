/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 17 Oct 2023
*/
package com.management.portal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
