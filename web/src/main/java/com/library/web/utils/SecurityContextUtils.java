package com.library.web.utils;

import java.util.HashSet;
import java.util.Set;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.TokenVerifier;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecurityContextUtils {
	private static final String ANONYMOUS = "anonymous";

	private SecurityContextUtils() {
	}

	@SuppressWarnings({"unchecked", "unused"})
	public static String getUserName() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String username = ANONYMOUS;

		if (null != authentication) {
			if (authentication.getPrincipal() instanceof KeycloakPrincipal) {
				KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) authentication
						.getPrincipal();
				username = getAccessToken(kp.getKeycloakSecurityContext().getTokenString())
						.getPreferredUsername();

			} else if (authentication.getPrincipal() instanceof String) {
				username = (String) authentication.getPrincipal();

			} else {
				log.debug("User details not found in Security Context");
			}

		} else {
			log.debug("Request not authenticated, hence no user name available");
		}

		return username;
	}

	public static AccessToken getAccessToken(String tokenString) {
		try {
			AccessToken token = TokenVerifier.create(tokenString, AccessToken.class).getToken();
			return token;
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return null;
	}

	public static Set<String> getUserRoles() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		Set<String> roles = new HashSet<>();

		if (null != authentication) {
			authentication.getAuthorities().forEach(e -> roles.add(e.getAuthority()));
		}
		return roles;
	}
}
