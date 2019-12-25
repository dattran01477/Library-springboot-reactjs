package com.library.web.utils;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextUtils {
	public static final Logger LOGGER = LoggerFactory.getLogger(SecurityContextUtils.class);

	private static final String ANONYMOUS = "ANONYMOUS";

	@SuppressWarnings("rawtypes")
	public static String getUserName() {
		try {
			KeycloakPrincipal principal = (KeycloakPrincipal) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
			AccessToken accessToken = session.getToken();
			return accessToken.getEmail();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return ANONYMOUS;
	}

}
