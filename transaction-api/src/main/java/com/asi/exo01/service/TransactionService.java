package com.asi.exo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asi.exo01.exception.CardNotFoundException;
import com.asi.exo01.exception.UserNotFoundException;
import com.asi.exo01.model.Card;
import com.asi.exo01.model.User;
import com.asi.exo01.repository.CardRepository;
import com.asi.exo01.repository.UserRepository;

@Service
public class TransactionService {
	
	@Autowired
	private final CardRepository cRepository;
	
	@Autowired
	private final UserRepository uRepository;
	
	public TransactionService(CardRepository cRepository, UserRepository uRepository) {
		super();
		this.cRepository = cRepository;
		this.uRepository = uRepository;
	}
	
	public Card getCard(Integer intCard) {
		return cRepository.findById(intCard)
				.orElseThrow(() -> new CardNotFoundException());
	}
	
	public User getUser(Integer intUser) {
		return uRepository.findById(intUser)
				.orElseThrow(() -> new UserNotFoundException(intUser));
	}
	
	public Card buyCard(User user, Card card) {
		user.setSolde(user.getSolde() - card.getPrice());
		card.setUserId(user.getId());
		cRepository.save(card);
		uRepository.save(user);
		return card;
	}
	
	public Card sellCard(User user, Card card) {
		user.setSolde(user.getSolde() + card.getPrice());
		card.setUserId(null);
		cRepository.save(card);
		uRepository.save(user);
		return card;
	}
}
