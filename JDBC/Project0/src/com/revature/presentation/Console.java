package com.revature.presentation;

import java.util.Scanner;

import com.revature.dao.BankAccount;
import com.revature.dao.BankDao;
import com.revature.pogo.Users;

public class Console {

	public static void welcome() {
		System.out.println("**********************************");
		System.out.println("*Welcome to the Future of Banking*");
		System.out.println("**********************************\n");
	}

	public static Users login() {
		BankDao bank = new BankAccount();
		Users user = null;
		String username = "";
		String password = "";
		Scanner scan = new Scanner(System.in);

		do{
		System.out.println("Enter Username");
		username = scan.nextLine();

		System.out.println("Enter Password");
		password = scan.nextLine();
		
		user = bank.confirmUser(username, password);
		} while(user == null);
		
		return user;
	}

	public static void mainMenu() {
		System.out.println("What would you like you do?");
		System.out.println("Please choose from one of the options below.\n");
		System.out.println("Enter 1 to Deposit");
		System.out.println("Enter 2 to Withdraw");
		System.out.println("Enter 3 for Available Balance");
		System.out.println("Enter 4 to Log Out");
	}

	public static void deposit(int usersId) {
		BankDao bank = new BankAccount();
		Scanner scan = new Scanner(System.in);

		System.out.println("How much would you like deposit?");
		double depositAmount = scan.nextDouble();

		bank.setDepositAmount(usersId, depositAmount);
	}

	public static void withdraw(int usersId) {
		BankDao bank = new BankAccount();
		Scanner scan = new Scanner(System.in);

		System.out.println("How much would you like withdraw?");
		double withdrawAmount = scan.nextDouble();

		bank.setWithdrawAmount(usersId, withdrawAmount);
	}

}
