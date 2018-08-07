package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.bl.BusinessLogic;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.exceptions.WrongInputException;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class DepositScreen implements Screen {

	@Override
	public Screen start() throws RuntimeException {
		BankDao bd = new BankDaoImpl();
		BankAccount ba = bd.getBankAccountInfo(Users.getUser().getId());
		System.out.println("How much would you like to deposit?");
		double amount = new BusinessLogic().checkDoubleInputException();
		if (amount == 0) {
			return this;
		}
		if (BusinessLogic.depositToAccount(amount, ba.getAccount_number())) {
			System.out.println("Deposit successful!");
			System.out.println("You have deposited: $" + amount);
			System.out.println();
			return new UserMenuScreen();
		} else {
			return this;
		}
	}
}
