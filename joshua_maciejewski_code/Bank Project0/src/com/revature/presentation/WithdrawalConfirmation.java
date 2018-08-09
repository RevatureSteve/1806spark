package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WithdrawalConfirmation implements Screen {
	
	private Scanner scan = new Scanner(System.in);
	
	public Screen start() {
		System.out.println("Withdrawal succesful");
		System.out.println("What next?");
		System.out.println("Enter 1 to go back to main menu. ");
		System.out.println("Enter 2 to log out.");
		
		
		try { int input = scan.nextInt();
		
		switch (input) {
		case 1:
			return new MainMenu();
		case 2:
			System.out.println("Have a nice day!");
			System.exit(1);
			
		}
		
		} catch  (InputMismatchException e) {
			System.out.println("please enter a number");
			return new WithdrawalConfirmation();
		}
		
		
		return new LoginScreen();
	}

}
