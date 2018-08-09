package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {

	
	//dao : data access object
	// this dao will be specifically for persistence of flashcards
	
	
	
	//create--- method that will use an insert sql statement
	public int createFlashCard(FlashCard fc);
	public void createFlashCardProc(FlashCard fc);
	
	//read -- method that will use select statement 
	public List<FlashCard> getFlashCards();
	public FlashCard getFlashCardById(int id);
	
	//update --  method that will use an update sql statement
	
	//delete -- method that will use a delete sql statement 
}
