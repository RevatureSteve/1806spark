package com.revature.presentation;

import java.util.InputMismatchException;

import java.util.Scanner;

import com.revature.abstractClasses.UserDao;
import com.revature.concreteClasses.User;
import com.revature.dao.UserDaoImplementation;


public class PresentationLogic {
	
	
	public static void presentScreen() {
		
		System.out.println("\n\n**************************************************************************************************************************************************************************************************\n");
		System.out.println("\t\t\t\t\t\t\t                 Welcome to Humphrey Central Bank!\n");
		System.out.println("******************************************************************************************************************************************************************************************************\n");
		System.out.println("\tPlease select a menu option:\n");
		System.out.println("\tEnter 1: Login to your account");
		System.out.println("\tEnter 2: Register for an HCB Account");
		System.out.println("\tEnter 3: Leave banking application\n");
	}
																																					
	public static void AfterLoginScreen() {
		
		System.out.println();
		System.out.println("\tPlease select a menu option:\n");
		System.out.println("\tEnter 1: View account balance");
		System.out.println("\tEnter 2: Make a deposit");
		System.out.println("\tEnter 3: Withdraw money from account");
		System.out.println("\tEnter 4: View recent transactions");
		System.out.println("\tEnter 5: Close your existing account");
		System.out.println("\tEnter 6: Sign Out\n");
	}
	
	public static int depositScreen() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println();
		System.out.println("\tPlease enter the amount you would like to deposit: ");
		int amount = scanny1.nextInt();
		
		return amount;
	}
	
	public static int withdrawScreen() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println();
		System.out.println("\tPlease enter the amount you would like to withdraw: ");
		int amount = scanny1.nextInt();
		return amount;
	}
	
	
	public static User creatingNewUser() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n************************************************************************************************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\t\t\tCreating A New HCB Account! Or Type Exit (at anytime) to go back to main menu\n\n");
		System.out.println("******************************************************************************************************************************************************************************************************\n");
		System.out.print("\tEnter your first name: ");
		String fname = scanny1.nextLine();
		if(fname.equalsIgnoreCase("exit")) {
			return new User(138,"hminott","junior1996","Humphrey","Minott");
		}
		System.out.println();
		System.out.print("\tEnter your last name: ");
		String lname = scanny1.nextLine();
		if(lname.equalsIgnoreCase("exit")) {
			return new User(138,"hminott","junior1996","Humphrey","Minott");
		}
		System.out.println();
		System.out.print("\tCreate a Username: ");
		String usernameFormat= scanny1.nextLine();
		if(usernameFormat.equalsIgnoreCase("exit")) {
			return new User(138,"hminott","junior1996","Humphrey","Minott");
		}
		String username = usernameFormat.toLowerCase();
		System.out.println();
		System.out.print("\tCreate a password: ");
		String password1 = scanny1.nextLine();
		if(password1.equalsIgnoreCase("exit")) {
			return new User(138,"hminott","junior1996","Humphrey","Minott");
		}
		System.out.println();
		System.out.print("\tConfirm password: ");
		String password2= scanny1.nextLine();
		if(password2.equalsIgnoreCase("exit")) {
			return new User(138,"hminott","junior1996","Humphrey","Minott");
		}
		while((!password2.equals(password1)))
			{
				System.out.println();
				System.out.println("\tPasswords do not match! Try Again...\n\n");
				System.out.print("\tCreate a password: ");
				password1 = scanny1.nextLine();
				if(password1.equalsIgnoreCase("exit")) {
					return new User(138,"hminott","junior1996","Humphrey","Minott");
				}
				System.out.println();
				System.out.print("\tConfirm password: ");
				password2= scanny1.nextLine();
				if(password2.equalsIgnoreCase("exit")) {
					return new User(138,"hminott","junior1996","Humphrey","Minott");
				}
			}
		System.out.println();
		System.out.println();
		User newCustomer = new User(0, username, password1, fname, lname);
		return newCustomer;
	}
	
	public static User loginScreen() {
		Scanner scanny1 = new Scanner(System.in);
		User registerCustomer = null;
		System.out.println("\n\n*******************************************************************************************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\t\t\t\tLogin! Or Type Exit (at anytime) to Go back to main menu\n\n");
		System.out.println("*************************************************************************************************************************************************************************************************\n");
		System.out.print("\tEnter your username: ");
		String usernameFormat = scanny1.nextLine();
		String username = usernameFormat.toLowerCase();
		if(username.equalsIgnoreCase("exit")) {
			return new User(138,"hminott","junior1996","Humphrey","Minott");
		}
		System.out.println();
		System.out.print("\tEnter your password: ");
		String password = scanny1.nextLine();	
		if(password.equalsIgnoreCase("exit")) {
			return new User(138,"hminott","junior1996","Humphrey","Minott");
		}
		UserDao lookUpCustomer = new UserDaoImplementation();
		registerCustomer = lookUpCustomer.getUserByUsername(username);
		while(registerCustomer == null) {
			System.out.println("\n\n\tIncorrect Username or Password\n\tTry again!");
			System.out.print("\n\tEnter your username: ");
			String usernameFormat2 = scanny1.nextLine();
			username = usernameFormat2.toLowerCase();
			if(username.equalsIgnoreCase("exit")) {
				return new User(138,"hminott","junior1996","Humphrey","Minott");
			}
			System.out.println();
			System.out.print("\n\tEnter your password: ");
			password = scanny1.nextLine();
			if(password.equalsIgnoreCase("exit")) {
				return new User(138,"hminott","junior1996","Humphrey","Minott");
			}
			registerCustomer = lookUpCustomer.getUserByUsername(username);
		}
			while(!(registerCustomer.getPassword().equals(password))) {
				System.out.println("\n\tIncorrect Username or Password\n\t\t\t\t\tTry again!");
				System.out.print("\n\tEnter your username: ");
				String usernameFormat3 = scanny1.nextLine();
				username = usernameFormat3.toLowerCase();
				if(username.equalsIgnoreCase("exit")) {
					return new User(138,"hminott","junior1996","Humphrey","Minott");
				}
				System.out.println();
				System.out.print("\n\tEnter your password: ");
				password = scanny1.nextLine();
				if(password.equalsIgnoreCase("exit")) {
					return new User(138,"hminott","junior1996","Humphrey","Minott");
				}
				registerCustomer = lookUpCustomer.getUserByUsername(username);
			}
		System.out.println("\n\t\t\t\t\t\t\t\t\tWelcome Back, " + registerCustomer.getFname() + " " + registerCustomer.getLname());
		
		return registerCustomer;
	}
	
	public static int validateUserAgain(User person) {
		User validateCustomer = null;
		UserDao lookUpCustomer = new UserDaoImplementation();
		Scanner scanny1 = new Scanner(System.in);
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t\tPermissions");
		System.out.println("\t\t\t\t\tRevalidate User Authentication (Type exit at anytime to return to previous screen)");
		System.out.println();
		System.out.print("\n\tEnter your password: ");
		String password = scanny1.nextLine();
		if(password.equalsIgnoreCase("exit")) {
			return 1;
		}
		validateCustomer = lookUpCustomer.getUserByUsername(person.getUsername());
		while(!(validateCustomer.getPassword().equals(password))) {
			System.out.println("\n\tIncorrect Password\n\t\t\t\t\tTry again or Exit!");
			System.out.print("\n\tEnter your password: ");
			password = scanny1.nextLine();
			if(password.equalsIgnoreCase("exit")) {
				return 1;
			}
		}
		
		return 0;
	}
	
	public static void successMessage() {
		System.out.println("\t\t\t\t\t\t\tYou've Successfully Created an account with Humphrey Central Bank");
		System.out.println("\t\t\t\t\t\t\t\t\t\tNow, login to your account");
	}
	
	public static void errorMessage() {
		System.out.println("\t\t\t\t\t\t\tOops...Sorry, something went wrong... \nRegsitration Failed");
		System.out.println("\t\t\t\t\t\t\t\t\t\tThis error is logged, try again later");
	}

	public static void successDepositMessage() {
		System.out.println("\t\t\t\t\t\tYou've Successfully deposited money into your account with Humphrey Central Bank");
		System.out.println("\t\t\t\t\t\t\t\t\t\tHave a nice day!");
	}
	public static void failDepositMessage() {
		System.out.println("\t\t\t\t\t\tOops... We encountered a problem when trying to deposit funds into your account");
		System.out.println("\t\t\t\t\t\t\t\t\t\tHave a nice day!");
	}
	
	public static void successWithdrawMessage() {
		System.out.println("\t\t\t\t\t\tYou've Successfully withdrew money from your account at Humphrey Central Bank");
		System.out.println("\t\t\t\t\t\t\t\t\t\tHave a nice day!");
	}
	
	public static void failWithdrawMessage() {
		System.out.println("\t\t\t\t\t\tOops... We encountered a problem when trying to withdraw funds from your account");
		System.out.println("\t\t\t\t\t\t\t\t\t\tInsufficient funds, cannot have a negative balance :(");
	}
	
}
