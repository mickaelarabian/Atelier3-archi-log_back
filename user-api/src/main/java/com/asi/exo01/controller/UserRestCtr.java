package com.asi.exo01.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asi.exo01.exception.MissParamException;
import com.asi.exo01.model.User;
import com.asi.exo01.service.UserService;

@ControllerAdvice
@CrossOrigin(origins = "http://127.0.0.1:8083")
@RestController
public class UserRestCtr {

	private final UserService uService;
	
	public UserRestCtr(UserService uService) {
		this.uService=uService;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Integer id){
		return uService.getUser(id);
	}
	
	@GetMapping("/users/{username}")
	public User getUser(@PathVariable String surname){
		return uService.getUserBySurname(surname);
	}
	
	@RequestMapping(value="/users", method={RequestMethod.OPTIONS,RequestMethod.POST})
	public User createUser(@RequestBody User u) {
//		return 15;
		System.out.println("ca passe");
		if (u.getName() != null && u.getPwd() != null && u.getSurname() != null) {
			u.setSolde(100);
			return uService.createUser(u);
//			return 15;
		}
		throw new MissParamException();
	}
}
