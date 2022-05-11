package com.asi.exo01.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(Integer id) {

        super(String.format("User with Id " + id + " not found"));
    }
}
