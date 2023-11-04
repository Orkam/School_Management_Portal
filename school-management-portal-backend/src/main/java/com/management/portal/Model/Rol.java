/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 17 Oct 2023
*/
package com.management.portal.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Roles")
public class Rol {
	
	@Id
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "rol")
	private Set<UserRol>userRoles = new HashSet<>();
	
	

	public Rol() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRol> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRol> userRoles) {
		this.userRoles = userRoles;
	}

	
}
