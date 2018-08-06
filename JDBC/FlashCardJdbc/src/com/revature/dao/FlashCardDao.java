package com.revature.dao;

import java.util.List;

import com.revature.pojo.BankUsers;

public interface FlashCardDao {

	
	//CRETE
	public int createFlashCard(BankUsers fc);
	public void creatFlashCardProc(BankUsers fc);
	//READ
	public List<BankUsers> getAllFlashCards();
	public BankUsers getFlashCardById(int id);
	//UPDATE
	
	//DELETE
}
