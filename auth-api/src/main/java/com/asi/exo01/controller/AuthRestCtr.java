
package com.asi.exo01.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.asi.exo01.exception.MissParamException;
import com.asi.exo01.model.User;
import com.asi.exo01.service.AuthService;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
public class AuthRestCtr {

	private final AuthService authService;
	
	public AuthRestCtr(AuthService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(value="/auth/register", method={RequestMethod.OPTIONS,RequestMethod.POST})
	public User register(@RequestBody User u) throws IOException {
		
		if (u.getName() != null && u.getPwd() != null && u.getSurname() != null) {
			u.setSolde(100);
			return authService.register(u);
		}
		throw new MissParamException();
	}
	
	@PostMapping("/auth/login")
	public Integer login(@RequestBody User u) {
		if (u.getSurname() != null && u.getPwd() != null) {
			return authService.login(u);
		}
		throw new MissParamException();
	}
}
