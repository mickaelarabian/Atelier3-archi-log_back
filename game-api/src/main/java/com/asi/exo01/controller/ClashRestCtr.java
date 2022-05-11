package com.asi.exo01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.asi.exo01.exception.UserNotFoundException;
import com.asi.exo01.model.Clash;
import com.asi.exo01.service.CardService;
import com.asi.exo01.service.UserService;

@CrossOrigin(origins = "http://127.0.0.1:8081")
@RestController
public class ClashRestCtr {

private final CardService cService;
private final UserService uService;
	
	public ClashRestCtr(CardService cService, UserService uService) {
		this.cService=cService;
		this.uService=uService;
	}
	
	//Instance bdd avec 20 cards et 2 users
	@GetMapping("/instance")
	public String getInstance() {
		if (cService.getCards().size() != 0 && uService.getUsers().size() != 0) {
			return "base déja instanciée";
		}
		cService.instanceBdd();
		return "base instanciée avec succès !";
	}
	
	//id du user 
	@GetMapping("/cards/{id}/sell")
	public List<Clash> getCardsToSell(@PathVariable Integer id) {
		if (uService.getUser(id) == null) {
			throw new UserNotFoundException(id);
		}
		return cService.getCardsToSell(id);
	}
	
	@GetMapping("/cards/buy")
	public List<Clash> getCardsToBuy() {
		return cService.getCardsToBuy();
	}
}
