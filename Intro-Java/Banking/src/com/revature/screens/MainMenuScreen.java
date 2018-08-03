package com.revature.screens;

import java.util.Scanner;

import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;

public class MainMenuScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	
	public MainMenuScreen() {
		
	}

	@Override
	public Screen start() {
		IOHandler.displayMainMenuScreen();
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			return new BalanceScreen();
		case "2":
			return new BalanceOperationScreen();
		case "3":
			return new LoginScreen();
		default:
			System.out.println("Not a recognized input");
		}
		
		
		return this;
	}

}
