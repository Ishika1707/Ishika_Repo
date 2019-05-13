package com.ripple.vmsystem.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {
	
	static PasswordEncoder encoder ;

	public static String getPasswordHash(String password) {
		String idForEncode = "bcrypt";
		 Map<String, PasswordEncoder> encoders = new HashMap<String, PasswordEncoder>();
		 encoders.put("bcrypt", new BCryptPasswordEncoder());
		 encoder = new DelegatingPasswordEncoder(idForEncode, encoders);
		return encoder.encode(password);
	}

}
