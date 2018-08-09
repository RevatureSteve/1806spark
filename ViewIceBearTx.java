package com.revature.presentation;

import java.util.List;

import com.revature.dao.TransactionDaoImpl;
import com.revature.pojo.Transaction;

public class ViewIceBearTx implements Screen {

	@Override
	public Screen start() {
		
		List<Transaction> txList = new TransactionDaoImpl().readTx();
		
		for(Transaction tx : txList) {
			Transaction trans = (Transaction) tx;
			System.out.println(trans);
		}
		
		return new MainMenu().start();
	}

}
