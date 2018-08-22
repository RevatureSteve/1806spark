package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {

	//DAO: Data Access Object
	// this DAO will be specifically for persistence of FlashCards
	
	// CREATE: a method that will use an insert sql statement
	public int createFlashCard(FlashCard fc);
	public void createFlashCardProc(FlashCard fc);
	
	
	// READ: a method that will use a select sql statement
	public List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);
	
	// UPDATE: a method that will use a update sql statement
	
	// DELETE: a method that will use a delete sql statement
	
}
