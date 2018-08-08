package com.revature;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.dao.BankDao;
import com.revature.exception.NoOverdraft;
import com.revature.exception.WrongType;
import com.revature.pogo.Account;
import com.revature.pogo.Users;
import com.revature.dao.BankAccount;
import com.revature.presentation.Console;

public class Driver {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		BankDao bank = new BankAccount();
		Scanner scan = new Scanner(System.in);

		Console.welcome();
		Users user = Console.login();

		while (true) {
			Console.mainMenu();
			int input = scan.nextInt();

			switch (input) {
			case 1:
				try {
					Console.deposit(user.getUsersId());
				} catch (WrongType e) {
					System.out.println("Invalid Format.\nPlease use a positive number with correct format *#.## or #*\n");
				}
				break;
			case 2:
				try {
					Console.withdraw(user.getUsersId());
				} catch (WrongType e) {
					System.out.println("Invalid Format.\nPlease use a positive number with correct format *#.## or #*\n");
				} catch (NoOverdraft e) {
					Account balance = bank.getBalance(user.getUsersId());
					System.out.println("Withdraw amount is to high.  Available balance is $" + balance.getBalance() + "\n");
				}
				break;
			case 3:
				Account balance = bank.getBalance(user.getUsersId());
				System.out.println("Available balance is $" + df.format(balance.getBalance()) + "\n");
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
