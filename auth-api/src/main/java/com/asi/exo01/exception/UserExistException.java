package com.asi.exo01.exception;

public class UserExistException extends RuntimeException {
	public UserExistException() {

        super(String.format("this user already exist"));
    }
}
