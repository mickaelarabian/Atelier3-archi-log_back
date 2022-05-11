package com.asi.exo01.exception;

public class BuyException extends RuntimeException {

	public BuyException() {

        super(String.format("You need more money to buy this card"));
    }
}
