package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.bl.BusinessLogic;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.exceptions.WrongInputException;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class WithdrawScreen implements Screen {

	@Override
	public Screen start() throws WrongInputException {
		BankDao bd = new BankDaoImpl();
		BankAccount ba = bd.getBankAccountInfo(Users.getUser().getId());
		System.out.println("How much would you like to withdraw?");
		double amount = new BusinessLogic().checkDoubleInputException();
		if (amount == 0) {
			return this;
		}
		if (new BusinessLogic().withdrawFromAccount(amount, ba.getAccount_number())) {
			System.out.println("Withdraw successful!");
			System.out.println("You withdrew: $" + amount);
			System.out.println();
			return new UserMenuScreen();
		} else {
			return this;
		}
	}
}
