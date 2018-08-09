package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

/**
 * Used for the persistence of the FlashCard bean
 * @author chin2
 *
 */
public interface FlashCardDao {
	// DAO - data access object
	
	// Create
	public int createFlashCard(FlashCard fc);
	public int createFlashCardProc(FlashCard fc);
	
	// Read
	public List<FlashCard>  getFlashCards();
	public FlashCard getFlashCardById(int id);
	
	// Update
	
	// Delete
}
