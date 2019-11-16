package com.library.web.api.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.UserServiceImpl;
import com.library.dao.model.UserModel;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping
	public UserModel getUserDetail() {
		KeycloakPrincipal principal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
		AccessToken accessToken = session.getToken();
		
		return userService.findByUsername(accessToken.getEmail());
	}
}
