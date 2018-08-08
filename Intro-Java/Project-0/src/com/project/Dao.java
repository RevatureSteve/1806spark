package com.project;

import java.util.List;

import com.project.pojo.BankTrans;

public interface Dao {

	
	//create
		public int create(Object obj);
	//read
		public List<Object> read();
		public static int getBal(int uId) {
			return uId;}
		public List<BankTrans> getTransactions(int user_id);
	//update
		public int update(Object obj);
		public static int newAcc(String newuser, String newpassword, String fname, String lname) {
			return 0;
		}
		public static int newTransaction(int uId, int newBal){
			return newBal;
			
		}
	//Delete
		
		
		
		
}
