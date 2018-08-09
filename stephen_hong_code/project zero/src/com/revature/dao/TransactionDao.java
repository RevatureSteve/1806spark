package com.revature.dao;

import java.util.List;

import com.revature.pojo.Transaction;

public interface TransactionDao {
	
	//DAO: Data Access Object
	//	this DAO will be specifically for persistence of bank accounts
	
	//	CREATE: a method that will use an insert sql statement
	public int createTx(Transaction tx);
//	public void createTxProc(Transaction tx);
	
	//	READ: a method that will use a select sql statement
	public List<Transaction> readTx();
//	public Transaction getTxById(int id);
	
	//	UPDATE: a method that will use a update sql statement
//	public int updateTx(Transaction tx);
	
	//	DELETE: a method that will use a delete sql statement
	


}
