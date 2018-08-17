package com.revature.presentation;

import java.util.Scanner;

import com.revature.ConsoleColors;
import com.revature.Screen;
import com.revature.bl.BusinessLogic;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class ViewTransactionHistory implements Screen{

	@Override
	public Screen start() {
		BankDao bd = new BankDaoImpl();
		BankAccount ba = bd.getBankAccountInfo(Users.getUser().getId());
		Scanner scan = new Scanner(System.in);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Here is your transaction history:");
		System.out.println(BusinessLogic.getTransactionHistory(ba.getAccount_number()));
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("Enter 1 to make a deposit");
		System.out.println("Enter 2 to withdraw");
		System.out.println("Enter 3 to view your balance");
		System.out.println("Enter 4 to logout");
		System.out.println("Enter 5 to logout and exit"+ConsoleColors.RESET);
		String choice = scan.nextLine();
		
		switch (choice) {
		case "1":
			return new DepositScreen();
		case "2":
			return new WithdrawScreen();
		case "3":
			return new ViewBalanceScreen();
		case "4":
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +"You have successfully logged out!");
			System.out.println();
			return new MainMenuScreen();
		case "5":
			System.out.println("Thank you for stopping by! May you live long and prosper!" + ConsoleColors.RESET);
			System.exit(1);
		default:
			System.out.println("Invalid input.  Please try again.");
		}
		return this;
	}

}