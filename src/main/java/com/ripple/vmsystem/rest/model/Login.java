package com.ripple.vmsystem.rest.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ripple.vmsystem.rest.model.User;

public class Login implements UserDetails{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private User user;
    private boolean enabled;     
    
    public Login(String username, String password, User user, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.user = user;
		this.enabled = enabled;
	}
    @Override
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	public User getUser() {
		return user;
	}

}
