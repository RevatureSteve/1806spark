package com.revature.screens;

import com.revature.dao.BankAccountDao;
import com.revature.exceptions.OverdraftPreventionException;
import com.revature.exceptions.WrongInputTypeException;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.pojos.BankAccount;
import com.revature.singletons.LoggedUser;

public class WithdrawScreen implements Screen {

	@Override
	public Screen start() {
		IOHandler.displayWithdrawScreen();
		BankAccountDao badao = new BankAccountDao();
		double money = 0;
		try {
			money = IOHandler.getAmountOfMoney();
		} catch (WrongInputTypeException e1) {
			System.out.println("Wrong input type, input a number, please.");
			return this;
		}
		BankAccount ba = badao.getBankAccountByUserId(LoggedUser.getUser().getUserId());
		
		try {
			badao.withdraw(money, ba.getAccount_number());
		} catch (OverdraftPreventionException e) {
			System.out.println("Withdrawal too high!");
		}
		return new MainMenuScreen();
	}
	

}
