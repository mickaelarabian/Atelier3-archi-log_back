package com.asi.exo01.exception;

public class CardCantBeSellException extends RuntimeException {

	public CardCantBeSellException() {

        super(String.format("Impossible to sell this card"));
    }
}
