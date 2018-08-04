package com.revature.present;

import java.util.Scanner;

import com.revature.interfaces.Screen;

public class MainMenuScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please choose one of the following options:");
		System.out.println("Enter 1 to make a withdrawl");
		System.out.println("Enter 2 to make a deposit");
		System.out.println("Enter 3 to logout");
		
		int userInput = scan.nextInt();
		
		switch (userInput) {
			case 1:
				return new WithdrawlScreen().start();
			case 2:
				return new DepositScreen().start();
			case 3:
				System.out.println("User is logging out...");
				System.exit(1);
		}
		
		
		
		return this;
	}

}
