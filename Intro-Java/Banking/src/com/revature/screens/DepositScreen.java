package com.revature.screens;

import com.revature.dao.BankAccountDao;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.pojos.BankAccount;
import com.revature.singletons.LoggedUser;

public class DepositScreen implements Screen {

	@Override
	public Screen start() {
		IOHandler.displayDepositScreen();
		BankAccountDao badao = new BankAccountDao();
		int money = IOHandler.getAmountOfMoney();
		BankAccount ba = badao.getBankAccountByUserId(LoggedUser.getUser().getUserId());
		badao.deposit(money, ba.getAccount_number());
		return new MainMenuScreen();
	}

}
