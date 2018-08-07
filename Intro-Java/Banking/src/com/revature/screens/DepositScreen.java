package com.revature.screens;

import com.revature.dao.BankAccountDao;
import com.revature.exceptions.NegativeInputException;
import com.revature.exceptions.WrongInputTypeException;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.pojos.BankAccount;
import com.revature.singletons.LoggedUser;

public class DepositScreen implements Screen {

	@Override
	public Screen start() {
		IOHandler.displayDepositScreen();
		BankAccountDao badao = new BankAccountDao();
		double money = 0;
		try {
			money = IOHandler.getAmountOfMoney();
		} catch (WrongInputTypeException e) {
			System.out.println("Wrong input type, input a number, please.");
			return this;
		} catch (NegativeInputException e) {
			System.out.println("Please don't put in negative deposit amount;");
			return this;
		}
		BankAccount ba = badao.getBankAccountByUserId(LoggedUser.getUser().getUserId());
		badao.deposit(money, ba.getAccount_number());
		IOHandler.successfulTransaction();
		return new MainMenuScreen();
	}

}
