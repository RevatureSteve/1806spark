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
		System.out.println("\tEnter 5: Sign Out\n");
	}
	
	
	
	public static User creatingNewUser() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n************************************************************************************************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\t\t\t\t\tCreating A New HCB Account!\n\n");
		System.out.println("******************************************************************************************************************************************************************************************************\n");
		System.out.print("\tEnter your first name: ");
		String fname = scanny1.nextLine();
		System.out.println();
		System.out.print("\tEnter your last name: ");
		String lname = scanny1.nextLine();
		System.out.println();
		System.out.print("\tCreate a Username: ");
		String usernameFormat= scanny1.nextLine();
		String username = usernameFormat.toLowerCase();
		System.out.println();
		System.out.print("\tCreate a password: ");
		String password1 = scanny1.nextLine();
		System.out.println();
		System.out.print("\tConfirm password: ");
		String password2= scanny1.nextLine();
		while((!password2.equals(password1)))
			{
				System.out.println();
				System.out.println("\tPasswords do not match! Try Again...\n\n");
				System.out.print("\tCreate a password: ");
				password1 = scanny1.nextLine();
				System.out.println();
				System.out.print("\tConfirm password: ");
				password2= scanny1.nextLine();
			}
		System.out.println();
		System.out.println();
		User newCustomer = new User(0, username, password1, fname, lname);
		return newCustomer;
	}
	
	public static void loginScreen() {
		Scanner scanny1 = new Scanner(System.in);
		User registerCustomer = null;
		System.out.println("\n\n*******************************************************************************************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\t\t\t\t\t\tLogin!\n\n");
		System.out.println("*************************************************************************************************************************************************************************************************\n");
		System.out.print("\tEnter your username: ");
		String usernameFormat = scanny1.nextLine();
		String username = usernameFormat.toLowerCase();
		System.out.println();
		System.out.print("\tEnter your password: ");
		String password = scanny1.nextLine();	
		UserDao lookUpCustomer = new UserDaoImplementation();
		registerCustomer = lookUpCustomer.getUserByUsername(username);
		while(registerCustomer == null) {
			System.out.println("\n\tIncorrect Username or Password\n\tTry again!");
			System.out.print("\n\tEnter your username: ");
			username = scanny1.nextLine();
			System.out.println();
			System.out.print("\n\tEnter your password: ");
			password = scanny1.nextLine();
			registerCustomer = lookUpCustomer.getUserByUsername(username);
		}
			while(!(registerCustomer.getPassword().equals(password))) {
				System.out.println("\n\tIncorrect Username or Password\n\tTry again!");
				System.out.print("\n\tEnter your username: ");
				username = scanny1.nextLine();
				System.out.println();
				System.out.print("\n\tEnter your password: ");
				password = scanny1.nextLine();
				registerCustomer = lookUpCustomer.getUserByUsername(username);
			}
		System.out.println("\n\t\t\t\t\t\t\t\t\tWelcome Back, " + registerCustomer.getFname() + " " + registerCustomer.getLname());
		
		
	}
	
	public static void successMessage() {
		System.out.println("\t\t\t\t\t\t\tYou've Successfully Created an account with Humphrey Central Bank");
		System.out.println("\t\t\t\t\t\t\t\t\t\tNow, login to your account");
	}
	
	public static void errorMessage() {
		System.out.println("\t\t\t\t\t\t\tOops...Sorry, something went wrong... \\nRegsitration Failed");
		System.out.println("\t\t\t\t\t\t\t\t\t\tThis error is logged, try again later");
	}

	
}
