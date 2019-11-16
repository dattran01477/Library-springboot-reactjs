package com.library.web.config.security.provider.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.KeycloakRole;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Service;

import com.library.bussiness.service.UserService;
import com.library.dao.enums.RoleEnum;
import com.library.dao.enums.StatusEnum;
import com.library.dao.model.UserModel;

@Service
public class ApplicationAuthenticationProvider implements AuthenticationProvider {

	private GrantedAuthoritiesMapper grantedAuthoritiesMapper;

	@Autowired
	UserService userService;

	public void setGrantedAuthoritiesMapper(GrantedAuthoritiesMapper grantedAuthoritiesMapper) {
		this.grantedAuthoritiesMapper = grantedAuthoritiesMapper;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) authentication;
		KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
		KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
		AccessToken accessToken = session.getToken();
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		String usernameKc = accessToken.getEmail();
		UserModel user = userService.findByUsername(usernameKc);

		if (user == null) {
			user = new UserModel();
			user.setUsername(usernameKc);
			user.setEmail(usernameKc);
			user.setStatus(StatusEnum.ACTIVE);
			user.setRole(RoleEnum.USER);
			
			userService.create(user);
		}

		for (String role : token.getAccount().getRoles()) {
			grantedAuthorities.add(new KeycloakRole(role));
		}

		return new KeycloakAuthenticationToken(token.getAccount(), token.isInteractive(),
				mapAuthorities(grantedAuthorities));
	}

	private Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
		return grantedAuthoritiesMapper != null ? grantedAuthoritiesMapper.mapAuthorities(authorities) : authorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return KeycloakAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
