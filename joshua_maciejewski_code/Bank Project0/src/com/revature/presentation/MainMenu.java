package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.InvalidInput;




public class MainMenu implements Screen{
	
	//public static BankDao dao = new LoginDaoImpl();
	//public static BankAccount acc = dao.getAccountInfo(5555);
	
	private Scanner scan = new Scanner(System.in);
	
	public Screen start() {
		
		System.out.println("Enter 1 to view your balance.");
		System.out.println("Enter 2 to make a deposit.");
		System.out.println("Enter 3 to make a withdrawal.");
		System.out.println("Enter 4 to quit...");
		
		try{ int input = scan.nextInt();
		
		switch (input) {
		case 1:
			return new Balance();
		case 2:
			return new DepositAmountScreen();
		case 3:
			return new WithdrawalAmountScreen();
		case 4:
			System.out.println("Have a nice day!");
			System.exit(1);
		default:
			try {
				throw new InvalidInput();
			} catch (Exception e) {
				System.out.println("Invalid input.. try again please");
					
			}
		}
		
		} catch  (InputMismatchException e) {
			System.out.println("please enter a number");
			return new MainMenu();
		}
		
		return new MainMenu();
	}

}


