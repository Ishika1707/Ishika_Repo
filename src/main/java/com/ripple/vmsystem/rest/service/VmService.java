package com.ripple.vmsystem.rest.service;

import java.util.List;

import com.ripple.vmsystem.rest.model.Vm;

public interface VmService {

	List<Vm> findVmsByUsernameIgnoreCase(String string);

	Vm save(Vm vm);

}
