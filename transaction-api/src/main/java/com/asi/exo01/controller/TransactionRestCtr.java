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
	public String buy(@RequestBody buyRequest request) {
		if (request.getCardId() == null || request.getUserId() == null) {
			throw new MissParamException();
		}
		return tService.buyCard(request.getCardId(), request.getUserId(), request);
	}
	
	@RequestMapping(value="/sell", method={RequestMethod.OPTIONS,RequestMethod.POST})
	public String sell(@RequestBody buyRequest request) {
		if (request.getCardId() == null || request.getUserId() == null) {
			throw new MissParamException();
		}
		return tService.sellCard(request.getCardId(), request.getUserId(), request);
	}
}
