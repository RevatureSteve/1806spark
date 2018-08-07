package com.revature.iohandler;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.exceptions.NegativeInputException;
import com.revature.exceptions.WrongInputTypeException;
import com.revature.pojos.Transaction;
import com.revature.pojos.User;
import com.revature.singletons.LoggedUser;

public class IOHandler {
	public static void getUser() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please provide login");
		String username = scan.nextLine();
		System.out.println("Please provide password");
		String password = scan.nextLine();
		LoggedUser.createUser(username, password);
	}
	
	public static int getCreateOrLogin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose 'login' or 'create'");
		String choose = scan.nextLine();
		if(choose.equals("create")) {
			return 0;
		}
		return 1;
	}
	public static void usernameExistsStatus() {
		System.out.println("Username already exists.");
	}
	
	public static void displayBalanceScreen(double balance) {
		printBreakLine();
		displayBalance(balance);
		printBreakLine();
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
		printBreakLine();
		System.out.println("Please select one of the choices");
		System.out.println("1 to view balance");
		System.out.println("2 to deposit or withdraw money");
		System.out.println("3 to visit transaction history");
		System.out.println("4 to log out");
	}
	
	private static void displayWelcomeBanner() {
		System.out.println(
				"  ____              _             __   _    _  _____         \r\n" + 
				" |  _ \\            | |           / _| | |  | |/ ____|  /\\    \r\n" + 
				" | |_) | __ _ _ __ | | __   ___ | |_  | |  | | (___   /  \\   \r\n" + 
				" |  _ < / _` | '_ \\| |/ /  / _ \\|  _| | |  | |\\___ \\ / /\\ \\  \r\n" + 
				" | |_) | (_| | | | |   <  | (_) | |   | |__| |____) / ____ \\ \r\n" + 
				" |____/ \\__,_|_| |_|_|\\_\\  \\___/|_|    \\____/|_____/_/    \\_\\\r\n" + 
				"                                                             \r\n" + 
				"                                                             ");
		
	}

	public static void displayBalanceOperationScreen() {
		printBreakLine();
		System.out.println("Please select one of the choices");
		System.out.println("1 to deposit");
		System.out.println("2 to to withdraw");
		System.out.println("3 to main menu");

	}

	public static void displayDepositScreen() {
		printBreakLine();
		System.out.println("Select the amount of money to deposit: ");
	}
	
	public static void displayWithdrawScreen() {
		printBreakLine();
		System.out.println("Select the amount of money to withdraw: ");
	}
	
	public static double getAmountOfMoney() throws WrongInputTypeException, NegativeInputException{
		Scanner scan = new Scanner(System.in);
		double money = 0;
		try {
			money = scan.nextDouble();
		} catch (Exception e) {
			throw new WrongInputTypeException();
		}
		if(money < 0) {
			throw new NegativeInputException();
		}
		return money;
	}

	public static void displayTransactions(ArrayList<Transaction> transactions) {
		printBreakLine();
		for(Transaction t : transactions) {
			System.out.println(t.toString());
		}
		
	}
	
	public static void printBreakLine() {
		System.out.println("");
	}
	
	public static void successfulTransaction() {
		System.out.println("Transaction successful");
	}

	public static User displayCreateUserScreen() {
		printBreakLine();
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
