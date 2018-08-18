package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {
<<<<<<< HEAD
	
	//DAO: Data Access Object
	// this DAO will be specifically for persistence of FlashCards
	
	
	
	//CREATE: a method that will use a select sql statement
=======

	//DAO: Data Access Object
	// this DAO will be specifically for persistence of FlashCards
	
	// CREATE: a method that will use an insert sql statement
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public int createFlashCard(FlashCard fc);
	public void createFlashCardProc(FlashCard fc);
	
	
<<<<<<< HEAD
	//READ: a method that will use a select sql statement
	public List<FlashCard> getAllFlashCards();
	public  FlashCard getFlashCardById(int id);
	
	//UPDATE: a method that will use an update sql statement
	
	
	//DELETE: a method that will use a delete sql statement
=======
	// READ: a method that will use a select sql statement
	public List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);
	
	// UPDATE: a method that will use a update sql statement
	
	// DELETE: a method that will use a delete sql statement
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
