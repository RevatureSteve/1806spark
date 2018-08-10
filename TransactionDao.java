package com.revature.dao;

import java.util.List;

import com.revature.pojo.Transaction;

public interface TransactionDao {
	
	//	CREATE:insert
	public int createTx(Transaction tx);
	
	public void createTxProc(Transaction tx);
	
	//	READ: select 
	public List<Transaction> readTx();
	
	public Transaction getTxById(int id);
	
	//	UPDATE: update 
	public int updateTx(Transaction tx);
	
	//	DELETE:  delete, not yet implemented
	


}