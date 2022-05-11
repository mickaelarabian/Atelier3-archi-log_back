package com.asi.exo01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.asi.exo01.model.Clash;


public interface ClashRepository extends CrudRepository<Clash, Integer> { 
	
	public Clash save(Clash c); 
	public List<Clash> findAll();
	public List<Clash> findByUserIdIsNull();
	public List<Clash> findByUserId(Integer id);
	public Optional<Clash> findById(Integer id);
}
