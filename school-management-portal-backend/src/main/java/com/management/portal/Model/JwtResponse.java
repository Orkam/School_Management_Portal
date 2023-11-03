/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 3 Nov 2023
*/
package com.management.portal.Model;

public class JwtResponse {

	private String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public JwtResponse() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
