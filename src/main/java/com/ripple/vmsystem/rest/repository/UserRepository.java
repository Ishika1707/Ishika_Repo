package com.ripple.vmsystem.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ripple.vmsystem.rest.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsernameIgnoreCase(String name);

}
