package com.ripple.vmsystem.rest.service;

import java.util.Collection;

import com.ripple.vmsystem.rest.model.User;

public interface UserService {
	
	User save(User user);

	User getUserByUsername(String name);

	Collection<User> findAll();

}
