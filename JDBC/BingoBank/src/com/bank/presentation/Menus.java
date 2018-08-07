package com.bank.presentation;

import java.util.Scanner;

import com.bank.dao.BankDao;
import com.bank.pojos.User;

public class Menus {
	
	
	
	//Welcome menu with login
	public void welcome () {
		System.out.println("****************************************");
		System.out.println("            Welcome to Bingo Bank \n            Please sing in");
		System.out.println("****************************************");
		System.out.println("Please enter username:");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
	}

	
	public void mainMenu() {
		User us = new User();
		us.getFirst_name();
		System.out.println("*****************************");
		System.out.println("What would you like to do?");
		System.out.println("  Enter 1. See balance");
		System.out.println("  Enter 2. Withdraw");
		System.out.println("  Enter 3. Deposit");
		System.out.println("  Enter 4.Logout");
		System.out.println("*****************************");
		Scanner scan = new Scanner(System.in);
		BankDao bd = new BankDao();
		switch (scan.nextInt()) {
		case 1:
			bd.getBalance();
			mainMenu();
			break;
		case 2:
			System.out.println("How much would you like to witdraw?");
			bd.makeWithdrawl(scan.nextInt());
			mainMenu();
			break;
		case 3: 
			System.out.println("How much would you like to deposit?");
			bd.makeDeposit(scan.nextInt());
			mainMenu();
			break;	
		case 4:
			System.out.println("Your login session has successfuly ended. Thank you");
			System.exit(0);
		default:
			mainMenu();
		}
	
	}
}
