package com.ripple.vmsystem.rest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ripple.vmsystem.rest.repository.UserRepository;
import com.ripple.vmsystem.security.PasswordUtil;
import com.ripple.vmsystem.rest.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreatedDate(new Date());
		return repository.save(user);
	}

	@Override
	public User getUserByUsername(String name) {
		return repository.findByUsernameIgnoreCase(name);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) repository.findAll();
		
	}

}
