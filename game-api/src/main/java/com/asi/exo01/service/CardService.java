package com.asi.exo01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asi.exo01.model.Clash;
import com.asi.exo01.model.Room;
import com.asi.exo01.repository.ClashRepository;
import com.asi.exo01.repository.RoomRepository;

@Service
public class CardService {

	@Autowired
	private final ClashRepository cRepository;
	
	@Autowired
	private final RoomRepository uRepository;
	
	public CardService(ClashRepository cRepository, RoomRepository uRepository) {
		super();
		this.cRepository = cRepository;
		this.uRepository = uRepository;
	}
	
	public void instanceBdd() {
		Room user1 = new Room("theyyooo", "123", "theo", 500);
		Room user2 = new Room("xharaly", "123", "charles", 50);
		
		uRepository.save(user1);
		uRepository.save(user2);
		
		Clash card1 = new Clash("card1", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card2 = new Clash("card2", "description", "family", "affinity", 100, 100, 50,50, 50, 1);
		Clash card3 = new Clash("card3", "description", "family", "affinity", 100, 100, 50,50, 50, 2);
		Clash card4 = new Clash("card4", "description", "family", "affinity", 100, 100, 50,50, 50, 1);
		Clash card5 = new Clash("card5", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card6 = new Clash("card6", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card7 = new Clash("card7", "description", "family", "affinity", 100, 100, 50,50, 50, 1);
		Clash card8 = new Clash("card8", "description", "family", "affinity", 100, 100, 50,50, 50, 2);
		Clash card9 = new Clash("card9", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card10 = new Clash("card10", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card11 = new Clash("card11", "description", "family", "affinity", 100, 100, 50,50, 50, 1);
		Clash card12 = new Clash("card12", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card13 = new Clash("card13", "description", "family", "affinity", 100, 100, 50,50, 50, 2);
		Clash card14 = new Clash("card14", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card15 = new Clash("card15", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card16 = new Clash("card16", "description", "family", "affinity", 100, 100, 50,50, 50, 1);
		Clash card17 = new Clash("card17", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card18 = new Clash("card18", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card19 = new Clash("card19", "description", "family", "affinity", 100, 100, 50,50, 50, null);
		Clash card20 = new Clash("card20", "description", "family", "affinity", 100, 100, 50,50, 50, 2);
		
		cRepository.save(card1);
		cRepository.save(card2);
		cRepository.save(card3);
		cRepository.save(card4);
		cRepository.save(card5);
		cRepository.save(card6);
		cRepository.save(card7);
		cRepository.save(card8);
		cRepository.save(card9);
		cRepository.save(card10);
		cRepository.save(card11);
		cRepository.save(card12);
		cRepository.save(card13);
		cRepository.save(card14);
		cRepository.save(card15);
		cRepository.save(card16);
		cRepository.save(card17);
		cRepository.save(card18);
		cRepository.save(card19);
		cRepository.save(card20);
	}

	public List<Clash> getCardsToBuy() {
		return cRepository.findByUserIdIsNull();
	}
	
	public List<Clash> getCardsToSell(Integer id) {
		return cRepository.findByUserId(id);
	}
	
	public List<Clash> getCards() {
		return cRepository.findAll();
	}
	
}
