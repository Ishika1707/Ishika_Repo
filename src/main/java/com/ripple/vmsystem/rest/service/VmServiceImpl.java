package com.ripple.vmsystem.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripple.vmsystem.rest.model.Vm;
import com.ripple.vmsystem.rest.repository.VmRepository;
@Service
public class VmServiceImpl implements VmService{
	
	@Autowired
	VmRepository vmRepository;

	public VmServiceImpl(VmRepository vmRepository) {
		this.vmRepository = vmRepository;
	}

	@Override
	public Vm save(Vm vm) {
		return vmRepository.save(vm);
	}

	@Override
	public List<Vm> findVmsByUsernameIgnoreCase(String username) {
		return vmRepository.findVmsByUsernameIgnoreCase(username);
	}

}
