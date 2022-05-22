package com.asi.exo01.exception;

public class MissParamException extends RuntimeException {
	public MissParamException() {

        super(String.format("Parameters are missing"));
    }
}
