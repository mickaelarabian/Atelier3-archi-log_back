package com.asi.exo01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asi.exo01.exception.UserNotFoundException;
import com.asi.exo01.model.Room;
import com.asi.exo01.repository.RoomRepository;

@Service
public class UserService {
	@Autowired
	private final RoomRepository uRepository;

	public UserService(RoomRepository uRepository) {
		this.uRepository = uRepository;
	}
	
	public List<Room> getUsers() {
		return uRepository.findAll();
	}
	
	public Room getUser(Integer id) {
			return uRepository.findById(id)
					.orElseThrow(() -> new UserNotFoundException(id));
	}
}
