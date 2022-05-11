package com.asi.exo01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.asi.exo01.exception.UserNotFoundException;
import com.asi.exo01.model.Card;
import com.asi.exo01.service.CardService;
import com.asi.exo01.service.UserService;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
public class CardRestCtr {

private final CardService cService;
//private final UserService uService;
	
	public CardRestCtr(CardService cService) {
		this.cService=cService;
//		this.uService=uService;
	}
	
//	//Instance bdd avec 20 cards et 2 users
//	@GetMapping("/instance")
//	public String getInstance() {
//		if (cService.getCards().size() != 0 && uService.getUsers().size() != 0) {
//			return "base déja instanciée";
//		}
//		cService.instanceBdd();
//		return "base instanciée avec succès !";
//	}
//	
	//id du user 
//	@GetMapping("/cards/{id}/sell")
//	public List<Card> getCardsToSell(@PathVariable Integer id) {
//		if (uService.getUser(id) == null) {
//			throw new UserNotFoundException(id);
//		}
//		return cService.getCardsToSell(id);
//	}
	
	@GetMapping("/cards/buy")
	public Boolean getCardsToBuy() {
		return true;
	}
}
