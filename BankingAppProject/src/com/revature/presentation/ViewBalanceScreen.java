package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class ViewBalanceScreen implements Screen{

	@Override
	public Screen start() {
		BankDao bd = new BankDaoImpl();
		BankAccount ba = bd.getBankAccountInfo(Users.getUser().getId());
		Scanner scan = new Scanner(System.in);
		System.out.println("Your current balance is: $" + ba.getBalance());
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("Enter 1 to make a deposit");
		System.out.println("Enter 2 to withdraw");
		System.out.println("Enter 3 to view transaction history");
		System.out.println("Enter 4 to exit");
		String choice = "";
		try {
				choice = scan.nextLine();
		} catch (RuntimeException e) {
			System.out.println("Wrong input type. Please try again.");
			return this;
		}
		
		switch (choice) {
		case "1":
			return new DepositScreen();
		case "2":
			return new WithdrawScreen();
		case "3":
			return new ViewTransactionHistory();
		case "4":
			System.out.println("Thanks for stopping by! We'll catch you later!");
			System.exit(1);
		default:
			System.out.println("Invalid input.  Please try again.");
			return this;
		}
		
	}
	
	
}
