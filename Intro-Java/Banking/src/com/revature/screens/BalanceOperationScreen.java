package com.revature.screens;

import java.util.Scanner;

import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;

public class BalanceOperationScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	@Override
	public Screen start() {
		
		IOHandler.displayBalanceOperationScreen();
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			return new DepositScreen();
		case "2":
			return new WithdrawScreen();
		case "3":
			return new MainMenuScreen();
		default:
			System.out.println("Not a recognized input");
		}
		return this;
	}

}
