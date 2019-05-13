package com.ripple.vmsystem.rest.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ripple.vmsystem.rest.model.User;
import com.ripple.vmsystem.rest.model.Vm;
import com.ripple.vmsystem.rest.service.UserService;
import com.ripple.vmsystem.rest.service.VmService;
import com.ripple.vmsystem.security.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders="Access-Control-Allow-Origin")

public class VmController {
@Autowired	
private VmService vmService;
@Autowired	
private UserService userService;
	
	public VmController(VmService vmService) {
        this.vmService = vmService;
    }

    @GetMapping("/getVmData?{userName}")
    public ResponseEntity<Response> getVMs(@PathVariable("userName") String userName) {
    	User user = userService.getUserByUsername(userName);
    	if(user != null) {
    		return (ResponseEntity<Response>) vmService.findVmsByUsernameIgnoreCase(user.getUsername());
    	}
        return new ResponseEntity<Response>(new Response("No VM records found for the user"), HttpStatus.OK);
    }
    
    @PostMapping("/createVmRequest/{username}")
    public ResponseEntity<Response> requestVM(@RequestBody Vm vm, @PathVariable("username") String username) {
    	System.out.println("Request has come here");
		System.out.println(vm.getRam());
		User user = userService.getUserByUsername(username);
		vm.setUsername(user.getUsername());
		Vm machine = vmService.save(vm);
		if(machine!=null) {
        	return new ResponseEntity<Response>(new Response("Vm request created successfully"), HttpStatus.OK);
        }
        return null;
    }


}
