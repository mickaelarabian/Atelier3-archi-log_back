package com.asi.exo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.asi.exo01.exception.CardNotFoundException;
import com.asi.exo01.exception.UserNotFoundException;
import com.asi.exo01.request.buyRequest;

@Service
public class TransactionService {
	
	public TransactionService() {
		super();

	}
	
	public String buyCard(Integer cardId, Integer userId, buyRequest request) {
		String URL_UPDATE_USER = "http://localhost:8080/users/{userId}";
		String URL_UPDATE_CARD = "http://localhost:8080/cards/{cardId}";

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(URL_UPDATE_USER, request, String.class);
		restTemplate.put(URL_UPDATE_CARD, request, String.class);

		return null;
	}
	
	public String sellCard(Integer cardId, Integer userId, buyRequest request) {
		String URL_UPDATE_USER = "http://localhost:8080/users/{userId}";
		String URL_UPDATE_CARD = "http://localhost:8080/cards/{cardId}";

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(URL_UPDATE_USER, request, String.class);
		restTemplate.put(URL_UPDATE_CARD, request, String.class);

		return null;
	}
}
