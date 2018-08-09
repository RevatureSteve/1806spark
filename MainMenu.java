package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.business.Service;
import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public class MainMenu implements Screen {
	
	@Override
	public Screen start() {
		
		Scanner scan = new Scanner(System.in);
		
		User currentUser = User.getCurrentUser();
		
		System.out.println("Welcome, " + currentUser.getfName() + " " + currentUser.getlName());
		Service.findUserAccount(currentUser.getUserId());
		System.out.println(BankAccount.getCurrentAccount());
		System.out.println("                                        ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("                                        ");
		System.out.println("Choose a transaction: ");
		System.out.println("1: Deposit seals");
		System.out.println("2: Withdraw seals");
		System.out.println("3: View transaction history");
		System.out.println("4: Account logout");
		System.out.println("5: Exit");
		
		try {
			int userInput = scan.nextInt();
		
			switch (userInput) {
				case 1:
					return new DepositSeals().start();
				case 2:
					return new WithdrawSeals().start();
				case 3:
					return new ViewIceBearTx().start();
				case 4:
					System.out.println("Logging out...");
					return new Login().start();
				case 5:
					System.out.println("Leaving program...thank you for your patronage");
					System.exit(1);
				}
		} catch (InputMismatchException e) {
			System.out.println("please enter a number");
		}
		
		
		
		return this.start();
		
	}

}
