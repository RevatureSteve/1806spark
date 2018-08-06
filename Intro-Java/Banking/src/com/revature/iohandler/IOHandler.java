package com.revature.iohandler;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.exceptions.WrongInputTypeException;
import com.revature.pojos.Transaction;
import com.revature.pojos.User;
import com.revature.singletons.LoggedUser;

public class IOHandler {
	public static int getUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose 'login' or 'create'");
		String choose = scan.nextLine();
		if(choose.equals("create")) {
			return 0;
		}
		System.out.println("Please provide login");
		String username = scan.nextLine();
		System.out.println("Please provide password");
		String password = scan.nextLine();
		LoggedUser.createUser(username, password);
		return 1;
	}
	
	public static void displayBalanceScreen(double balance) {
		displayBalance(balance);
		System.out.println("Please select one of the choices");
		System.out.println("1 to main menu");
		System.out.println("2 to deposit or withdraw money");
		System.out.println("3 to log out");
	}
	
	public static void displayBalance(double balance) {
		System.out.println("Your current balance is: $" + balance);
	}
	
	public static void displayMainMenuScreen() {
		displayWelcomeBanner();
		System.out.println("Please select one of the choices");
		System.out.println("1 to view balance");
		System.out.println("2 to deposit or withdraw money");
		System.out.println("3 to visit transaction history");
		System.out.println("4 to log out");
	}
	
	private static void displayWelcomeBanner() {
		System.out.println("Welcome");
	}

	public static void displayBalanceOperationScreen() {
		System.out.println("Please select one of the choices");
		System.out.println("1 to deposit");
		System.out.println("2 to to withdraw");
		System.out.println("3 to main menu");

	}

	public static void displayDepositScreen() {
		System.out.println("Select the amount of money to deposit: ");
	}
	
	public static void displayWithdrawScreen() {
		System.out.println("Select the amount of money to withdraw: ");
	}
	
	public static double getAmountOfMoney() throws WrongInputTypeException{
		Scanner scan = new Scanner(System.in);
		double money = 0;
		try {
			money = scan.nextDouble();
		} catch (Exception e) {
			throw new WrongInputTypeException();
		}
		return money;
	}

	public static void displayTransactions(ArrayList<Transaction> transactions) {
		for(Transaction t : transactions) {
			System.out.println(t.toString());
		}
		
	}

	public static User displayCreateUserScreen() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide username");
		String username = scan.nextLine();
		System.out.println("Please provide password");
		String password = scan.nextLine();
		System.out.println("What is your first name?");
		String firstname = scan.nextLine();
		System.out.println("What is your last name?");
		String lastname = scan.nextLine();
		
		return new User(username, password, firstname, lastname);
	}
}
