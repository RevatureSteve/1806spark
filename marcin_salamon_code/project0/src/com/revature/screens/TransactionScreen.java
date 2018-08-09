package com.revature.screens;

import java.util.ArrayList;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.pojos.BankAccount;
import com.revature.pojos.Transaction;
import com.revature.singletons.LoggedUser;

public class TransactionScreen implements Screen {

	@Override
	public Screen start() {
		BankAccountDaoImpl badao = new BankAccountDaoImpl();
		BankAccount ba = badao.getBankAccountByUserId(LoggedUser.getUser().getUserId());
		ArrayList<Transaction> transactions = badao.getTransactionsByUser(ba.getAccount_number());
		if (transactions.size() > 0) {
			IOHandler.displayTransactions(transactions);
		} else {
			System.out.println("No transactions");
		}
		return new MainMenuScreen();
	}

}
