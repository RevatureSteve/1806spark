package com.revature.service;

import java.util.List;

import com.revature.model.FlashCard;

public interface AppService {

	//create
	void saveFlashCard(FlashCard fc);
	
	//read
	FlashCard getFlashCardById(int id);
	List<FlashCard> findAll();
	
	//update
	
	//delete
	
	
	
}
