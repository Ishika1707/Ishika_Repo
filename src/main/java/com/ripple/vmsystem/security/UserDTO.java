package com.ripple.vmsystem.security;

import java.io.Serializable;
import java.util.List;

import com.ripple.vmsystem.rest.model.User;
import com.ripple.vmsystem.rest.model.Vm;

public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private List<Vm> vmList;
	public UserDTO(User user, List<Vm> vmList, String token) {
		super();
		this.user = user;
		this.token = token;
		this.vmList = vmList;
	}
	private String token;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<Vm> getVmList() {
		return vmList;
	}
	public void setVmList(List<Vm> vmList) {
		this.vmList = vmList;
	}

}
