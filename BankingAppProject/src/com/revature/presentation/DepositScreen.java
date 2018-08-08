package com.revature.presentation;

import java.util.Scanner;

import com.revature.ConsoleColors;
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
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +"How much would you like to deposit?"+ConsoleColors.RESET);
		double amount = new BusinessLogic().checkDoubleInputException();
		if (amount == 0) {
			return this;
		}
		if (BusinessLogic.depositToAccount(amount, ba.getAccount_number())) {
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +"Deposit successful!"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +"You have deposited: ¤ " + amount + ConsoleColors.RESET);
			System.out.println();
			return new UserMenuScreen();
		} else {
			return this;
		}
	}
}
