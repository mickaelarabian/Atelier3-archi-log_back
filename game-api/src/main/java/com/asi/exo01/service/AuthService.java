package com.asi.exo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asi.exo01.exception.UserConnectionException;
import com.asi.exo01.exception.UserExistException;
import com.asi.exo01.model.Room;
import com.asi.exo01.repository.RoomRepository;

@Service
public class AuthService {

	@Autowired
	private final RoomRepository uRepository;

	public AuthService(RoomRepository uRepository) {
		this.uRepository = uRepository;
	}
	
	public Room register(Room u) {
		if (uRepository.findBySurname(u.getSurname()) == null){
			uRepository.save(u);
			return u;
		}
		throw new UserExistException();
		
	}
	
	public Integer login(Room u) {
		Room user = uRepository.findBySurname(u.getSurname());
		if (user != null && user.getPwd().equals(u.getPwd())) {
			return user.getId();
		}
		throw new UserConnectionException();
		
	}
}
