package com.revature.doa;

import java.util.List;

import com.revature.pojos.FlashCard;


public interface FlashCards {
	/*
	 * 
	 */
	public int createFlashCard(FlashCard fc);

	public List getFlashCards();
	public FlashCard getFlashCardById(int id);
}
