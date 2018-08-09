package com.cpo.dao;

import java.util.List;

import com.cpo.beans.Transaction;

public interface TransactionDao {
	
	int createTransactions( Transaction tx);
	
	List<Transaction> getTransactions(int account_number);
}
