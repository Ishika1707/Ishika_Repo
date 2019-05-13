package com.ripple.vmsystem.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ripple.vmsystem.rest.model.Login;
import com.ripple.vmsystem.rest.model.User;
import com.ripple.vmsystem.rest.repository.UserRepository;
import com.ripple.vmsystem.security.JwtUserFactory;

import static java.util.Collections.emptyList;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not found with username '%s' " , username));
        }else {
        	
        }
        return JwtUserFactory.create(user);
    }
    
	/*
	 * @Transactional public UserDetails loadUserByUsername(String usernameOrEmail)
	 * throws UsernameNotFoundException { // Let people login with either username
	 * or email User user = userRepository.findByUsernameOrEmail(usernameOrEmail,
	 * usernameOrEmail) .orElseThrow(() -> new
	 * UsernameNotFoundException("User not found with username or email : " +
	 * usernameOrEmail) );
	 * 
	 * return UserPrincipal.create(user); }
	 */
}
