package com.ripple.vmsystem.rest.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.ripple.vmsystem.security.Response;
import com.ripple.vmsystem.rest.model.User;
//import com.ripple.project.jwt.UserService;
import com.ripple.vmsystem.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;
	
	//@Autowired
	//private UserService userService;
	
	public UserController(UserService userService) {
        this.userService = userService;
    }

	
	/*
	 * @GetMapping("/getUser/{userId}") public ResponseEntity<User>
	 * getUser(Principal principal) { User user =
	 * repository.findByUsernameIgnoreCase(principal.getName()); return new
	 * ResponseEntity<User>(user, HttpStatus.OK);
	 * 
	 * }
	 */
	  
	@GetMapping("/getUsers")
	public Collection<User> getUsers() {
		System.out.println("Request has come here");
		// System.out.println(user.getUsername()); return (Collection<User>)
		return userService.findAll();
	}
	 
    @PostMapping("/createUser")
    public ResponseEntity<Response> saveUser(@RequestBody User user) {
    	System.out.println("Request has come here");
		System.out.println(user.getUsername());
		//User dbUser = userService.save(user);
		User dbUser = userService.save(user);
        if(dbUser!=null) {
        	return new ResponseEntity<Response>(new Response("User created successfully"), HttpStatus.OK);
        }
        return null;
    }

}
