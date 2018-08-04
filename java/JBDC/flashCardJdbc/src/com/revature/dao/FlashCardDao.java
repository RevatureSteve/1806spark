package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {
	// this is the contract that will implement by class or extend other interface
	//class implement interface
	// class extend class
	// what ever method create in contract will need to be create in any class or interface that used this contract

	/*
	 * DAO: DATA ACCESS OBJECT
	 * THIS DAO WILL BE specially for persistence of flashcard
	 * 
	 *
	 */
	
	//createL a method that will ud=sed an insert sql statement
	
	//read: a method taht will reada sql statement
	public List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardById(int id);
	
	//update: a method that will update a sql statement 
	
	
	//delete: a method that will delete a sql statement
	
	
}
