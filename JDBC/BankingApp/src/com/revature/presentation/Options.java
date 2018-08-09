package com.revature.presentation;

import java.util.Scanner;

import com.revature.dao.BankingAppDaoImpl;
import com.revature.exceptions.OverdraftException;
import com.revature.pojo.User;

public class Options {
	
	User nah = null;
	
	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}
	




	static void showOptions(User todd) {
	System.out.println("\n");
	System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
	System.out.println("\n");
	System.out.println("Welcome " + todd.getFirstName() +" "+ todd.getLastName() + "!");
	System.out.println("\n");
	System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
	System.out.println("Enter an option: ");
	System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
	Scanner scan = new Scanner(System.in);
	System.out.println("1. View your balance");
	System.out.println("2. Deposit money");
	System.out.println("3. Withdraw money");
	System.out.println("4. Logout");
	int option;
	
	
	while (true) {
		
	option = scan.nextInt();
	
	switch(option) {
	
	
	case 1:
		BankingAppDaoImpl balance = new BankingAppDaoImpl();
		int v = balance.balance(todd);
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Balance = " + "$"+ v);
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Options.showOptions(todd);
		break;
	
	case 2:
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Enter an amount to deposit: ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		int amount = scan.nextInt();
		if (amount > 0) {
		BankingAppDaoImpl deposit = new BankingAppDaoImpl();
		deposit.deposit(amount, todd);
		System.out.println("Successful Transaction!");
		Options.showOptions(todd);
	} else {System.err.println("Cannot deposit negative amount!");
		Options.showOptions(todd);}
//		deposit(amount);
		break;

	case 3:
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Enter an amount to withdraw: ");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		int amount2 = scan.nextInt();
		if (amount2 > 0) {
		BankingAppDaoImpl withdraw = new BankingAppDaoImpl();
		try {
		int check = withdraw.withdraw(amount2, todd);
		if(check==1) {
			System.out.println("Successful Transaction!");
		} else {
			throw new OverdraftException();
		}
		}catch (OverdraftException e) {
			System.err.println("Overdraft not allowed!");
		}
		Options.showOptions(todd);
		} else {System.err.println("Cannot withdraw negative amount!");
		Options.showOptions(todd);}
//		withdraw(amount2);
		break;
		
	case 4: 
		System.out.println("Thanks for using Southern Tosino Bank!");
		Menus.createBankingAppMenu();
		break;
	
	default:
		
		System.err.println("Invalid option! Please try again.");
		break;
	}
	
	}

	

	}

}
