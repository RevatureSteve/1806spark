package com.project;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.project.dao.UserDaoImpl;
import com.project.dao.AccountDaoImpl;
import com.project.dao.TransactionDaoImpl;
import com.project.exception.InvalidInputException;
import com.project.logic.Logic;
import com.project.pojo.BankBal;
import com.project.pojo.BankTrans;
import com.project.pojo.BankUsers;


public class MenuMaster implements HomeScreen{

	private Scanner scan = new Scanner(System.in);//this takes in input
	private int uId;
	private int bal;
	
	@Override
	public HomeScreen Start() {
		

		System.out.println("\n" + 
				"  ____              _             __    _____                 _ _     _       ______ _     _     \n" + 
				" |  _ \\            | |           / _|  / ____|               | (_)   | |     |  ____(_)   | |    \n" + 
				" | |_) | __ _ _ __ | | __   ___ | |_  | (_____      _____  __| |_ ___| |__   | |__   _ ___| |__  \n" + 
				" |  _ < / _` | '_ \\| |/ /  / _ \\|  _|  \\___ \\ \\ /\\ / / _ \\/ _` | / __| '_ \\  |  __| | / __| '_ \\ \n" + 
				" | |_) | (_| | | | |   <  | (_) | |    ____) \\ V  V /  __/ (_| | \\__ \\ | | | | |    | \\__ \\ | | |\n" + 
				" |____/ \\__,_|_| |_|_|\\_\\  \\___/|_|   |_____/ \\_/\\_/ \\___|\\__,_|_|___/_| |_| |_|    |_|___/_| |_|\n" + 
				"                                                                                                 \n" + 
				"                                                                                                 \n" + 
				"");
		
		System.out.println("Type 'login' to login.");
		System.out.println("type 'new' to create a new account!");
		System.out.println("Type 'exit' to exit...");
		
		String input = scan.nextLine();
		
		switch (input) {
		case "login":
			Login();
			break;
		
		case "new":
			newAccount();
			break;
		
		case "exit":
			System.out.println("Adjö! *Goodbye*");
			System.exit(1);
			break;
		default:
			try {
				throw new InvalidInputException();
			} catch (Exception e) {
				System.err.println("Invalid input... Please try again.");	
				Start();
			}
		
			
		}
		return this;// this returns current screen
	}
	private void newAccount() {
		System.out.println("Please enter a new username");
		String username = scan.nextLine();
		System.out.println("Please enter a new password");
		String password = scan.nextLine();
		System.out.println("What is your first name?");
		String fname = scan.nextLine();
		System.out.println("What is your last name?");
		String lname = scan.nextLine();
		if(Logic.userInDb(username, password)) {
			System.err.println("Username is taken...");
			
				newAccount();
		
			
		}else {
				AccountDaoImpl.newAcc(username, password, fname, lname);
				System.out.println("Account created!");
				Login();
		
			
		}

	}
	public HomeScreen Login() {
		System.out.println("Username: ");
		String username = scan.nextLine();
		System.out.println("Password: ");
		String password = scan.nextLine();
		if(Logic.userInDb(username, password)) {
			username = Logic.getFirstName(username, password);
			BankUsers i = BankUsers.getCurrentUser();
			String x = "" + i;
			uId = Integer.valueOf(x);
		    
			Valid(username);
		}
		System.err.println("Invalid login...");

		
		return this.Login();
}
	public HomeScreen Valid(String user) {
		bal = AccountDaoImpl.getBal(uId);
		System.out.println("Welcome back " + user);
		System.out.println("Type 'bal' to see your balance.");
		System.out.println("Type 'depo' to deposit.");
		System.out.println("Type 'with' to withdraw.");
		System.out.println("Type 'history' to view your transaction history.");
		System.out.println("Type 'exit' to logout...");
		String input = scan.nextLine();
		switch (input) {
		case "bal":
			Balance(user);
			break;
		case "depo":
			Deposit(user);
			break;
		case "with":
			Withdraw(user);
			break;
		case "history":
			transactionHistory(user);
			break;
		case "exit":
			System.out.println("\n" + 
					"  _______ _                 _           __            __      ___     _ _   _             _ \n" + 
					" |__   __| |               | |         / _|           \\ \\    / (_)   (_) | (_)           | |\n" + 
					"    | |  | |__   __ _ _ __ | | _____  | |_ ___  _ __   \\ \\  / / _ ___ _| |_ _ _ __   __ _| |\n" + 
					"    | |  | '_ \\ / _` | '_ \\| |/ / __| |  _/ _ \\| '__|   \\ \\/ / | / __| | __| | '_ \\ / _` | |\n" + 
					"    | |  | | | | (_| | | | |   <\\__ \\ | || (_) | |       \\  /  | \\__ \\ | |_| | | | | (_| |_|\n" + 
					"    |_|  |_| |_|\\__,_|_| |_|_|\\_\\___/ |_| \\___/|_|        \\/   |_|___/_|\\__|_|_| |_|\\__, (_)\n" + 
					"                                                                                     __/ |  \n" + 
					"                                                                                    |___/   \n" + 
					"");
			System.out.println("\n" + 
					"              _ _ _   _ _ \n" + 
					"     /\\      | (_|_) (_) |\n" + 
					"    /  \\   __| |_  ___ | |\n" + 
					"   / /\\ \\ / _` | |/ _ \\| |\n" + 
					"  / ____ \\ (_| | | (_) |_|\n" + 
					" /_/    \\_\\__,_| |\\___/(_)\n" + 
					"              _/ |        \n" + 
					"             |__/         \n" + 
					"");
			Start();
			break;

		default:
			try {
				throw new InvalidInputException();
			} catch (Exception e) {
				System.err.println("Invalid input... Please try again.");	
				Valid(user);
			}
		}
		return this;
	}
	
	public HomeScreen Balance(String user) {
		
		bal = AccountDaoImpl.getBal(uId);
		BankUsers bu = new BankUsers();
		System.out.println(user + ", you have a balance of: " + bal + " Swedish Fish");
		System.out.println("or type 'return' to return to previous menu...");
		String input = scan.nextLine();
		switch (input) {
		case "return":
			Valid(user);
			break;

		default:
			try {
				throw new InvalidInputException();
			} catch (Exception e) {
				System.err.println("Invalid input... Please try again.");	
				Balance(user);
			}
		}
		return this;
	}
	public HomeScreen Withdraw(String user) {
		System.out.println("How many Swedish Fish would you like to withdraw, " + user + "?");
		System.out.println("or type 'return' to return to previous menu...");
		String input = scan.nextLine();
		switch (input) {
		case "return":
			Valid(user);
			break;

		default:
			int x = 0;
			try {
				x = Integer.valueOf(input);
				if(x <= 0 ) {
					System.err.println("Invalid value!");
					Withdraw(user);
				}
			} catch (Exception e) {
				System.err.println("Invalid input...Try again...");
				Withdraw(user);
			}
			int y =- 0 - x;
			if(x > bal) {
				System.out.println("You can't withdraw that much \n You only have " + bal + " Sedish Fish...");
				return this.Withdraw(user);
			}else {
				int trans = bal - x;
				System.out.println("You are about to withdraw " + x + " Swedish Fish");
				System.out.println("This will leave you with a remainder of " +  trans + " Swedish Fish");
				System.out.println("Type 'y' to complete transaction or 'n' to cancel");
				String value = scan.nextLine();
				switch (value) {
				case "y":
					TransactionDaoImpl.newTransaction(uId, trans, y);
					System.out.println("Transaction completed");
					return this.Valid(user);
				case "n":
					System.out.println("Transaction canceled....");
					return this.Valid(user);

				default:
					try {
						throw new InvalidInputException();
					} catch (Exception e) {
						System.err.println("Invalid input... Please try again.");	
						Withdraw(user);
					}
				}
			}
			break;
		}
		
		return this;
	}
	public HomeScreen Deposit(String user) {
		System.out.println("How many Swedish Fish would you like to deposit, " + user + "?");
		System.out.println("or type 'return' to return to previous menu...");
		String input = scan.nextLine();
		switch (input) {
		case "return":
			Valid(user);
			break;
			
		default:
			int x = 0;
			try {
				x = Integer.valueOf(input);
				if(x <= 0 ) {
					System.err.println("Invalid value!");
					Deposit(user);
				}
			} catch (Exception e) {
				System.err.println("Invalid input...Try again...");
				Deposit(user);
			}
			
			int trans = bal + x;
			System.out.println("You are about to deposit " + x + " Swedish Fish");
			System.out.println("This will give you a total of " +  trans + " Swedish Fish");
			System.out.println("Type 'y' to complete transaction or 'n' to cancel");
			String value = scan.nextLine();
			switch (value) {
			case "y":
				TransactionDaoImpl.newTransaction(uId, trans, x);
				System.out.println("Transaction completed");
				return this.Valid(user);
			case "n":
				System.out.println("Transaction canceled....");
				return this.Valid(user);

			default:
				try {
					throw new InvalidInputException();
				} catch (Exception e) {
					System.err.println("Invalid input... Please try again.");	
					Deposit(user);
				}
			}
		}
		return this;
	}
	
	public HomeScreen transactionHistory(String user) {
		System.out.println("Here is your transaction history, " + user);
		System.out.println("Type return to return...");
		System.out.println(Logic.TransHistory(uId));
	    String input = scan.nextLine();
		switch (input) {
		case "return":
			
			break;

		default:
			try {
				throw new InvalidInputException();
			} catch (Exception e) {
				System.err.println("Invalid input... Please try again.");	
				transactionHistory(user);
			}
			
		}
		
		
		return this.Valid(user);
	}
	
		}

