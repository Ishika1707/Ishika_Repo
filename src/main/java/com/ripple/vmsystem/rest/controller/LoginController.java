package com.ripple.vmsystem.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ripple.vmsystem.security.PasswordUtil;
import com.ripple.vmsystem.rest.model.Login;
import com.ripple.vmsystem.rest.model.User;
import com.ripple.vmsystem.rest.model.Vm;
import com.ripple.vmsystem.rest.service.VmService;
import com.ripple.vmsystem.security.JWTTokenUtil;
import com.ripple.vmsystem.security.UnauthorizedException;
import com.ripple.vmsystem.security.UserDTO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class LoginController {

	@Value("$(jwt.header)")
	private String tokenHeader;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	VmService vmService;

	@Autowired
	JWTTokenUtil jWTTokenUtil;

	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> login(@RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			final Login loginUser = (Login) authentication.getPrincipal();
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jWTTokenUtil.generateToken(loginUser);
			response.setHeader("Token", token);
			List<Vm> vmList = new ArrayList<Vm>();
			vmList = vmService.findVmsByUsernameIgnoreCase(loginUser.getUser().getUsername());
			return new ResponseEntity<UserDTO>(new UserDTO(loginUser.getUser(), vmList, token), HttpStatus.OK);
		} catch (Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}

}
