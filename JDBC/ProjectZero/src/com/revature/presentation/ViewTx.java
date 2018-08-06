package com.revature.presentation;

import java.util.List;

import com.revature.dao.TransactionDaompl;
import com.revature.interfaces.Screen;
import com.revature.pojo.Transaction;

public class ViewTx implements Screen {

	@Override
	public Screen start() {
		
		List<Transaction> txList = new TransactionDaompl().readTx();
		
		for(Transaction tx : txList) {
			Transaction trans = (Transaction) tx;
			System.out.println(trans);
		}
		
		return new MainMenu().start();
	}

}
