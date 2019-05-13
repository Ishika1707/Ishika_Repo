package com.ripple.vmsystem.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ripple.vmsystem.rest.model.Vm;

@RepositoryRestResource
public interface VmRepository extends JpaRepository<Vm, Long>{
	List<Vm> findVmsByUsernameIgnoreCase(String username);
}
