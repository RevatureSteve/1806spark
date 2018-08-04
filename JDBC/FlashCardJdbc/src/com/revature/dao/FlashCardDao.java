package com.revature.dao;

import java.util.List;

import com.revature.FlashCard;

public interface FlashCardDao {

	//DAO: Data Access Object
	// this DAO will be specifically for persistence of FlashCards
	
	
	
	//CREATE
	
	
	
	
	
	
	//READ
	public default List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);
	
	
	
	
	//UPDATE
	
	
	
	
	
	//DELETE
	
	
}
