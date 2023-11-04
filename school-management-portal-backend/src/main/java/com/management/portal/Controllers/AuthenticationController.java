/**
@project school-management-portal-backend
@author Gustavo Guevara
@created 4 Nov 2023
*/
package com.management.portal.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.portal.Model.JwtRequest;
import com.management.portal.Model.JwtResponse;
import com.management.portal.Model.User;
import com.management.portal.security.JwtUtils;
import com.management.portal.services.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/generate-token")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception("User not found");
		}

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException exception) {
			throw new Exception("USER DISABLED " + exception.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID CREDENCIALS " + e.getMessage());
		}
	}

	@GetMapping("/actual-user")
	public User obtenerUsuarioActual(Principal principal) {
		return (User) this.userDetailsService.loadUserByUsername(principal.getName());
	}

}
