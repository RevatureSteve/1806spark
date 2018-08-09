package com.revature.dao;

import java.util.List;

<<<<<<< HEAD
import com.revature.FlashCard;
=======
import com.revature.pojo.FlashCard;
>>>>>>> fa66388667395c761e59539daaea36af9d01238b

public interface FlashCardDao {

	//DAO: Data Access Object
	// this DAO will be specifically for persistence of FlashCards
	
<<<<<<< HEAD
	
	
	//CREATE
	
	
	
	
	
	
	//READ
	public default List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);
	
	
	
	
	//UPDATE
	
	
	
	
	
	//DELETE
	
=======
	// CREATE: a method that will use an insert sql statement
	public int createFlashCard(FlashCard fc);
	public void createFlashCardProc(FlashCard fc);
	
	
	// READ: a method that will use a select sql statement
	public List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);
	
	// UPDATE: a method that will use a update sql statement
	
	// DELETE: a method that will use a delete sql statement
>>>>>>> fa66388667395c761e59539daaea36af9d01238b
	
}
