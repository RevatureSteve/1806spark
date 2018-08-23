package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {

	//Dao: Data Access Object
	//this DAO will be specifically for persistence of flashcards
	
	//CREATE: a method that will use an insert sql statement
	public int createFlashcard(FlashCard fc);
	public void createFlashcardProc(FlashCard fc);
	
	//READ: a method that will use a select sql statement
	public List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);
	
	//UPDATE: a method that will use an update sql statement
	
	//DELETE: am method that will use a delete sql statement
	
}
