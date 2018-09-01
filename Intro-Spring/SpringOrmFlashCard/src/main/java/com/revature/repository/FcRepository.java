package com.revature.repository;

import java.util.List;

import com.revature.beans.FlashCard;

public interface FcRepository {

	//CREATE
	void saveFc(FlashCard fc);
	
	//READ
	List<FlashCard> findAllFlashCards();
	//UPDATE
	//DELETE
}
