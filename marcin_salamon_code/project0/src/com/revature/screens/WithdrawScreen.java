package com.revature.screens;

import org.omg.IOP.IORHolder;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.exceptions.NegativeInputException;
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
		BankAccountDaoImpl badao = new BankAccountDaoImpl();
		double money = 0;
		try {
			money = IOHandler.getAmountOfMoney();
		} catch (WrongInputTypeException e1) {
			System.out.println("Wrong input type, input a number, please.");
			return this;
		} catch (NegativeInputException e) {
			System.out.println("Please don't input a negative withdraw amount.");
		}
		BankAccount ba = badao.getBankAccountByUserId(LoggedUser.getUser().getUserId());
		
		try {
			badao.withdraw(money, ba.getAccount_number());
		} catch (OverdraftPreventionException e) {
			System.out.println("Withdrawal too high!");
		}
		IOHandler.successfulTransaction();
		return new MainMenuScreen();
	}
	

}
