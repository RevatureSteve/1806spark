package com.revature.dao;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public interface BankDao  {
	
	//create
	
	public void createUser(String username, String password, String fname, String lname);
	
	//read
	
	public Users getUsername(String username);
	
	public BankAccount getAccountInfo(int id);
	
	
	//update
	
	public void enterDeposit(double amt, int accNum);
	
	public void enterWithdrawal(double amt, int accNum);
	
	//delete

}


////dao : data access object
//	// this dao will be specifically for persistence of flashcards
//	
//	
//	
//	//create--- method that will use an insert sql statement
//	public int createFlashCard(FlashCard fc);
//	public void createFlashCardProc(FlashCard fc);
//	
//	//read -- method that will use select statement 
//	public List<FlashCard> getFlashCards();
//	public FlashCard getFlashCardById(int id);
//	
//	//update --  method that will use an update sql statement
//	
//	//delete -- method that will use a delete sql statement 
//}
