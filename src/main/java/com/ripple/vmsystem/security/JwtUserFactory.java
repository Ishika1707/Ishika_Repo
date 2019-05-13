package com.ripple.vmsystem.security;


import org.springframework.security.core.userdetails.UserDetails;

import com.ripple.vmsystem.rest.model.Login;
import com.ripple.vmsystem.rest.model.User;

public class JwtUserFactory {

	public static UserDetails create(User user) {
		return new Login (user.getUsername(), user.getPassword(), user, user.isEnabled());
	}

}
