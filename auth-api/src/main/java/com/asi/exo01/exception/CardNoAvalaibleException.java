package com.asi.exo01.exception;

public class CardNoAvalaibleException extends RuntimeException {

	public CardNoAvalaibleException() {

        super(String.format("Impossible to buy this card"));
    }
}
