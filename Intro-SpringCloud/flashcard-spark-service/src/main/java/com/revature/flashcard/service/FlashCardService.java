package com.revature.flashcard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.flashcard.models.FlashCard;
import com.revature.flashcard.repo.FlashCardRepository;

@Service
public class FlashCardService {

	@Autowired
	public FlashCardRepository flashCardRepo;
	
	public Optional<FlashCard> getFlashCardById(int id) {
		return flashCardRepo.findById(id);
	}
	
	public void savefc(FlashCard fc) {
		flashCardRepo.save(fc);
	}
	
	public Iterable<FlashCard> getAllFlashCards() {
		return flashCardRepo.findAll();
	}
}
