package com.revature;

import java.util.Scanner;

import com.revature.dao.BankDao;
import com.revature.pogo.Account;
import com.revature.pogo.Users;
import com.revature.dao.BankAccount;
import com.revature.presentation.Console;

public class Driver {

	public static void main(String[] args) {
		BankDao bank = new BankAccount();
		Scanner scan = new Scanner(System.in);

		Console.welcome();
		Users user = Console.login();

		while (true) {
			Console.mainMenu();
			int input = scan.nextInt();

			switch (input) {
			case 1:
				Console.deposit(user.getUsersId());
				break;
			case 2:
				Console.withdraw(user.getUsersId());
				break;
			case 3:
				bank.getBalance(user.getUsersId());
				break;
			case 4:
				System.out.println("Have a good day!");
				System.exit(1);
				break;
			default:
				System.out.println("Sorry that is not a valid number from the options given.");
				break;
			}
		}

	}

}
