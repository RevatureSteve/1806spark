package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.businesslogic.Service;
import com.revature.interfaces.Screen;
import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public class MainMenu implements Screen {
	
	@Override
	public Screen start() {
		
		Scanner scan = new Scanner(System.in);
		
		User currentUser = User.getCurrentUser();
		//current user is set from Service class
		System.out.println("Welcome! " + currentUser.getFirstName() + " " + currentUser.getLastName());
		//get name of current user
		Service.applyUserAccount(currentUser.getUserId()); //get user id from current user and put it in this method
		//current account is set from Service class
		System.out.println(BankAccount.getCurrentAccount());
		//get account info of current account and display
		System.out.println("What would you like to do?");
		System.out.println("1: Make a deposit");
		System.out.println("2: Withdrawal");
		System.out.println("3: View transaction history");
		System.out.println("4: Logout");
		System.out.println("5: Exit program");
		
		try {
			int userInput = scan.nextInt();
		
			switch (userInput) {
				case 1:
					return new Deposit().start();
				case 2:
					return new Withdrawal().start();
				case 3:
					return new ViewTx().start();
				case 4:
					System.out.println("You are logging out...Thank you!");
					return new Login().start();
				case 5:
					System.out.println("Thank you! Good Bye!");
					System.exit(0);
				}
		} catch (InputMismatchException e) {
			System.out.println("Please choose from the choices below");
		}
		
		
		
		return this.start();
		
	}

}
