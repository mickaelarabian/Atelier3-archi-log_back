package com.asi.exo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asi.exo01.exception.CardNotFoundException;
import com.asi.exo01.exception.UserNotFoundException;
import com.asi.exo01.model.Clash;
import com.asi.exo01.model.Room;
import com.asi.exo01.repository.ClashRepository;
import com.asi.exo01.repository.RoomRepository;

@Service
public class TransactionService {
	
	@Autowired
	private final ClashRepository cRepository;
	
	@Autowired
	private final RoomRepository uRepository;
	
	public TransactionService(ClashRepository cRepository, RoomRepository uRepository) {
		super();
		this.cRepository = cRepository;
		this.uRepository = uRepository;
	}
	
	public Clash getCard(Integer intCard) {
		return cRepository.findById(intCard)
				.orElseThrow(() -> new CardNotFoundException());
	}
	
	public Room getUser(Integer intUser) {
		return uRepository.findById(intUser)
				.orElseThrow(() -> new UserNotFoundException(intUser));
	}
	
	public Clash buyCard(Room user, Clash card) {
		user.setSolde(user.getSolde() - card.getPrice());
		card.setUserId(user.getId());
		cRepository.save(card);
		uRepository.save(user);
		return card;
	}
	
	public Clash sellCard(Room user, Clash card) {
		user.setSolde(user.getSolde() + card.getPrice());
		card.setUserId(null);
		cRepository.save(card);
		uRepository.save(user);
		return card;
	}
}
