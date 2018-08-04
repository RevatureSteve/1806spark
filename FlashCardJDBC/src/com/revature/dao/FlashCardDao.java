package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {

	//DAO: Data Access Object
	//This DAO will be specifically for persistance of FlashCards
	
	//CREATE
	
	public int createFlashCard(FlashCard fc);
	public void createFlashCardProc(FlashCard fc);
	
	//READ
	public  List<FlashCard> getAllFlashCards();
	public FlashCard getFlashCardByID(int id);
	
	//UPDATE
	
	//DELETE
	
	
	
}
