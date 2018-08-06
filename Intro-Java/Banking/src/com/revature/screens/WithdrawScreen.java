package com.revature.screens;

import com.revature.dao.BankAccountDao;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.pojos.BankAccount;
import com.revature.singletons.LoggedUser;

public class WithdrawScreen implements Screen {

	@Override
	public Screen start() {
		IOHandler.displayWithdrawScreen();
		BankAccountDao badao = new BankAccountDao();
		int money = IOHandler.getAmountOfMoney();
		BankAccount ba = badao.getBankAccountByUserId(LoggedUser.getUser().getUserId());
		badao.withdraw(money, ba.getAccount_number());
		return new MainMenuScreen();
	}

}
