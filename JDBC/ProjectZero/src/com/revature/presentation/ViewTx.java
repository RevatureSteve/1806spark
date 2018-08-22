package com.revature.presentation;

import java.util.List;

import com.revature.dao.TransactionDaoImpl;
import com.revature.interfaces.Screen;
import com.revature.pojo.Transaction;

public class ViewTx implements Screen {

	@Override
	public Screen start() {
		List<Transaction> txList = new TransactionDaoImpl().readTx();
		//get transaction history of current user from SQL Bank_Tx table
		for(Transaction tx : txList) {
			//iterate through list using for loop
			Transaction trans = (Transaction) tx;
			//for each object in the list,
			System.out.println(trans);
			//print it to console
		}
		
		return new MainMenu().start();
	}

}
