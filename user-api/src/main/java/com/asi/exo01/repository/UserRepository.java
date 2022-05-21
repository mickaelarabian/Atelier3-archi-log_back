package com.asi.exo01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.asi.exo01.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User save(Optional<User> user);
	
	public Optional<User> findById(Integer id);
	
	public User findBySurname(String surname);
	
	public List<User> findAll();
}
