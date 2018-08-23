package com.revature.dao;

import java.util.List;

import com.revature.domain.FlashCard;

public interface FlashCardDao {
	/*
	 * CRUD Only 
	 */

	//Create
	public void createFlashCard(FlashCard fc);
	//Read
	public FlashCard getFlashCardById(int id);
	public List<FlashCard> getAllFlashCards();
	//Update
	
	//Delete
	
}
