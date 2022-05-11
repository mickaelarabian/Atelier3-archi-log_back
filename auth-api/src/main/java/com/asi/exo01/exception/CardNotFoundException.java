package com.asi.exo01.exception;

public class CardNotFoundException extends RuntimeException {

	public CardNotFoundException() {

        super(String.format("No cards found"));
    }
}
