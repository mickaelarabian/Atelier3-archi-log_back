package com.asi.exo01.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asi.exo01.exception.BuyException;
import com.asi.exo01.exception.CardNoAvalaibleException;
import com.asi.exo01.exception.MissParamException;
import com.asi.exo01.exception.UserNotFoundException;
import com.asi.exo01.model.Card;
import com.asi.exo01.request.buyRequest;
import com.asi.exo01.service.CardService;

@CrossOrigin(origins = "http://127.0.0.1:8082")
@RestController
public class CardRestCtr {

private final CardService cService;
//private final UserService uService;
	
	public CardRestCtr(CardService cService) {
		this.cService=cService;
//		this.uService=uService;
	}
	
	//Instance bdd avec 20 cards et 2 users
	@GetMapping("/cards/instance")
	public String getInstance() {
		if (cService.getCards().size() != 0) {
			return "base déja instanciée";
		}
		cService.instanceBdd();
		return "base instanciée avec succès !";
	}
	
	//id du user 
	@GetMapping("/cards/{id}/sell")
	public List<Card> getCardsToSell(@PathVariable Integer id) {
		return cService.getCardsToSell(id);
	}
	
	@GetMapping("/cards/{id}")
	public Optional<Card> getCard(@PathVariable Integer id) {
		return cService.getCard(id);
	}
	
	@GetMapping("/cards/buy")
	public List<Card> getCardsToBuy() {
		return cService.getCardsToBuy();
	}
	
	@PutMapping("/cards/{id}")
	public Card updateCard(@RequestBody Integer userId, @PathVariable Integer id, @RequestBody Boolean isSell) {
		return cService.updateCard(userId, id, isSell);
		
	}
}
