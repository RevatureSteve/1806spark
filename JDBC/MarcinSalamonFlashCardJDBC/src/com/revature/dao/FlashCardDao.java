package com.revature.dao;

import java.util.List;

import com.revature.pojos.FlashCard;

public interface FlashCardDao {
	
	//Create
	public int createFlashCard(FlashCard fc);
	//Read
	public List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);

	//Update
	
	//Delete
}
