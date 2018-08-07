package com.revature.screens;

import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.pojos.BankAccount;
import com.revature.singletons.LoggedUser;

public class BalanceScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	@Override
	public Screen start() {
		BankAccountDao baDao = new BankAccountDao();
		BankAccount ba = baDao.getBankAccountByUserId(LoggedUser.getUser().getUserId());
		IOHandler.displayBalanceScreen(ba.getBalance());
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			return new MainMenuScreen();
		case "2":
			return new BalanceOperationScreen();
		case "3":
			System.exit(0);
		default:
			System.out.println("Not a recognized input");
		}
		return this;
	}
}
