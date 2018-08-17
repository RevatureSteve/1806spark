package com.bank.presentation;

import java.util.Scanner;

import com.bank.dao.BankDaoImpl;
import com.bank.pojos.User;

public class Menus {
	
	
	
	//Welcome menu with login
	public void welcome () {
		System.out.println("****************************************");
		System.out.println("            Welcome to Bingo Bank \n              E-Yi-E-Yi-O Inc.\n              Please login");
		System.out.println("****************************************");
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
		BankDaoImpl bd = new BankDaoImpl();
		switch (scan.nextInt()) {
		case 1:
			bd.getBalance(2);
			mainMenu();
			break;
		case 2:
			System.out.println("How much would you like to witdraw?");
			bd.makeWitdrawl(scan.nextInt());
			mainMenu();
			break;
		case 3: 
			System.out.println("How much would you like to deposit?");
			bd.makeDeposit(scan.nextInt());
			mainMenu();
			break;	
		case 4:
			bd.logout();
		default:
			System.out.println("Please try agina");
		mainMenu();
		}
		scan.close();
	}
}
