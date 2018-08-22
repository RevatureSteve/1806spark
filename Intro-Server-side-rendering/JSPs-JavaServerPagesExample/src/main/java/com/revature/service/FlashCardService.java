package com.revature.service;

import com.revature.dao.Dao;
import com.revature.dao.DaoFcImpl;
import com.revature.model.FlashCard;

public class FlashCardService {

	Dao dao = new DaoFcImpl();
	
	/*
	 * This service class allows for a form of Encapsulation/Abstraction
	 */
	
	public FlashCard getFc(FlashCard fc){
		//Pull FC from DB
		return dao.getFc(fc.getId()); 
	}
	
}
