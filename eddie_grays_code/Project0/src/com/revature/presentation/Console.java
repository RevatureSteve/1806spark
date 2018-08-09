package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.BankAccount;
import com.revature.dao.BankDao;
import com.revature.exception.NoOverdraft;
import com.revature.exception.WrongType;
import com.revature.pogo.Account;
import com.revature.pogo.Users;

public class Console {

	public static void welcome() {
//		System.out.println("** * * * * * * * * * * * * * * * **");
//		System.out.println("* Welcome to the Future of Banking*");
//		System.out.println("** * * * * * * * * * * * * * * * **\n");

		System.out.println("**********************");
		System.out.println("*** Welcome to the ***");
		System.out.println("*  Future of Banking *");
		System.out.println("**********************\n");
	}

	public static Users login() {
		BankDao bank = new BankAccount();
		Users user = null;
		String username = "";
		String password = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Login");

		do {
			System.out.println("Enter Username");
			username = scan.nextLine();

			System.out.println("Enter Password");
			password = scan.nextLine();

			user = bank.confirmUser(username, password);
		} while (user == null);

		return user;
	}

	public static void mainMenu() {
		System.out.println("What would you like you do?");
		System.out.println("Please choose from one of the options below.\n");
		System.out.println("Enter 1 to Deposit Bitcoins");
		System.out.println("Enter 2 to Withdraw Bitcoins");
		System.out.println("Enter 3 for Available Bitcoins");
		System.out.println("Enter 4 to Log Out");
	}

	public static void deposit(int usersId) throws WrongType {
		BankDao bank = new BankAccount();
		double depositAmount = 0.0;

		do {
			System.out.println("How much would you like to deposit?");
			try {
				Scanner scan = new Scanner(System.in);
				depositAmount = scan.nextDouble();
				if (depositAmount < 0.0) {
					throw new WrongType();
				}
			} catch (InputMismatchException in) {
				throw new WrongType();
			}
		} while (depositAmount <= 0.0);

		bank.setDepositAmount(usersId, depositAmount);
	}

	public static void withdraw(int usersId) throws WrongType, NoOverdraft {
		BankDao bank = new BankAccount();
		Account balance = bank.getBalance(usersId);
		double withdrawAmount = 0.0;

		do {
			System.out.println("How much would you like to withdraw?");
			try {
				Scanner scan = new Scanner(System.in);
				withdrawAmount = scan.nextDouble();

				if (balance.getBalance() < withdrawAmount) {
					throw new NoOverdraft();
				} else if (withdrawAmount < 0.0) {
					throw new WrongType();
				}
			} catch (InputMismatchException in) {
				throw new WrongType();
			}
		} while (withdrawAmount <= 0.0 || balance.getBalance() < withdrawAmount);

		bank.setWithdrawAmount(usersId, withdrawAmount);
	}

}
