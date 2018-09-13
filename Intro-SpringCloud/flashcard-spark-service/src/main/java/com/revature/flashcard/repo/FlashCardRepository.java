package com.revature.flashcard.repo;

import org.springframework.data.repository.CrudRepository;

import com.revature.flashcard.models.FlashCard;

public interface FlashCardRepository extends CrudRepository<FlashCard, Integer> { 
	
	
}
