package com.asi.exo01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.asi.exo01.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {

	public Room save(Room u);
	
	public Room findBySurname(String surname);
	
	public List<Room> findAll();
}
