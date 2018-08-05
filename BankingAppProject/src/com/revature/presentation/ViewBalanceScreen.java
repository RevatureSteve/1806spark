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
		BankAccount ba = bd.getBankAccountInfo(Users.prelimUser().getId());
		Scanner scan = new Scanner(System.in);
		System.out.println("Here is your balance: $" + ba.getBalance());
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("Enter 1 to make a deposit");
		System.out.println("Enter 2 to withdraw");
		System.out.println("Enter 3 to view transaction history");
		System.out.println("Enter 4 to exit");
		String choice = scan.nextLine();
		
		switch (choice) {
		case "1":
			System.out.println("Makes a deposit");
			return new DepositScreen();
		case "2":
			System.out.println("Make a withdraw");
			return new WithdrawScreen();
		case "3":
			System.out.println("Viewing transaction history");
			return new ViewBalanceScreen();
		case "4":
			System.out.println("Exiting program");
			System.exit(1);
		}
		
		return this;
	}
	
	
}
