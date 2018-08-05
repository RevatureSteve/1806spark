package com.revature.present;

import java.util.List;

import com.revature.dao.TransactionDao;
import com.revature.interfaces.Screen;
import com.revature.pojo.BankTransaction;

public class TransactionScreen implements Screen{

	@Override
	public Screen start() {
		System.out.println("Transactions");
		
		List<Object> transactions = new TransactionDao().read();
		
		for(Object obj : transactions) {
			BankTransaction trans = (BankTransaction) obj;
			System.out.println(trans);
		}
		
		return new MainMenuScreen().start();
	}

}
