package com.asi.exo01.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.asi.exo01.exception.BuyException;
import com.asi.exo01.exception.CardCantBeSellException;
import com.asi.exo01.exception.CardNoAvalaibleException;
import com.asi.exo01.exception.MissParamException;
import com.asi.exo01.model.Card;
import com.asi.exo01.model.User;
import com.asi.exo01.request.buyRequest;
import com.asi.exo01.service.TransactionService;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
public class TransactionRestCtr {

private final TransactionService tService;
	
	public TransactionRestCtr(TransactionService tService) {
		this.tService=tService;
	}
	
	@RequestMapping(value="/buy", method={RequestMethod.OPTIONS,RequestMethod.POST})
	public Card buy(@RequestBody buyRequest request) {
		if (request.getCardId() == null || request.getUserId() == null) {
			throw new MissParamException();
		}
		User userObject = tService.getUser(request.getUserId());
		Card cardObject = tService.getCard(request.getCardId());
		if (cardObject.getUserId() != null) {
			throw new CardNoAvalaibleException();
		}
		if (cardObject.getPrice() <= userObject.getSolde()) {
			return tService.buyCard(userObject, cardObject);
		}
		throw new BuyException();
		
	}
	
	@RequestMapping(value="/sell", method={RequestMethod.OPTIONS,RequestMethod.POST})
	public Card sell(@RequestBody buyRequest request) {
		if (request.getCardId() == null || request.getUserId() == null) {
			throw new MissParamException();
		}
		Card cardObject = tService.getCard(request.getCardId());
		User userObject = tService.getUser(request.getUserId());
		if (cardObject.getUserId() != userObject.getId()) {
			throw new CardCantBeSellException();
		}
		return tService.sellCard(userObject, cardObject);
	}
}
