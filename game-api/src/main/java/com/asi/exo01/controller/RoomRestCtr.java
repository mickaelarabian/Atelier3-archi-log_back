package com.asi.exo01.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.asi.exo01.model.Room;
import com.asi.exo01.service.UserService;

@ControllerAdvice
@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
public class RoomRestCtr {

	private final UserService uService;
	
	public RoomRestCtr(UserService uService) {
		this.uService=uService;
	}
	
	@GetMapping("/user/{id}")
	public Room getUser(@PathVariable Integer id){
		return uService.getUser(id);
	}
}
