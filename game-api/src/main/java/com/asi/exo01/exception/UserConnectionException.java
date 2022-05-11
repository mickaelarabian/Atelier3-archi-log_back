package com.asi.exo01.exception;

public class UserConnectionException extends RuntimeException {

	public UserConnectionException() {

        super(String.format("the username or the password is wrong"));
    }
}
