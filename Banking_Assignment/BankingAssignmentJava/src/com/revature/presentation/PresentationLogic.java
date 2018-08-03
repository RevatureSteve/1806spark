package com.revature.presentation;

import java.util.Scanner;

import com.revature.concreteClasses.User;


public class PresentationLogic {
	
	
	public static void presentScreen() {
		
		System.out.println("\n\n********************************************************************************************************************************************************************\n");
		System.out.println("\t\t\t\t\t\t\t    Welcome to Humphrey Central Bank!\n");
		System.out.println("************************************************************************************************************************************************************\n");
		System.out.println("\tPlease select a menu option:\n");
		System.out.println("\tEnter 1: Login to your account");
		System.out.println("\tEnter 2: Register for an HCB Account");
		System.out.println("\tEnter 3: Leave banking application\n");
		System.out.println("**********************************************************************************************************************************************************************\n\n");
	}
	
	public static User creatingNewUser() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n******************************************************************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\t\t\tCreating A New HCB Account!\n\n");
		System.out.println("************************************************************************************************************************************************************************\n");
		System.out.print("\tEnter your first name: ");
		String fname = scanny1.nextLine();
		System.out.println();
		System.out.print("\tEnter your last name: ");
		String lname = scanny1.nextLine();
		System.out.println();
		System.out.print("\tCreate a User ID: ");
		int userId = scanny1.nextInt();
		scanny1.nextLine();
		System.out.println();
		System.out.print("\tCreate a Username: ");
		String username= scanny1.nextLine();
		System.out.println();
		System.out.println("\tCreate a password: ");
		String password1 = scanny1.nextLine();
		System.out.println();
		System.out.println("\tConfirm password: ");
		String password2= scanny1.nextLine();
		while((!password2.equals(password1)))
			{
				System.out.println("\tPasswords do not match! Try Again...\n\n");
				System.out.println("\tCreate a password: ");
				password1 = scanny1.nextLine();
				System.out.println();
				System.out.println("\tConfirm password: ");
				password2= scanny1.nextLine();
			}
		System.out.println();
		System.out.println("*************************************************************************************************************************************************************************");
		User newCustomer = new User(userId, fname, lname, username, password1);
//		Runnable persist = new NewThread(musical);
//		Thread runner = new Thread(persist);
//		runner.start();
		return newCustomer;
	
	}
	
	public static void loginScreen() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n*******************************************************************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\t\t\t\t\tLogin!\n\n");
		System.out.println("*************************************************************************************************************************************************************************\n");
		System.out.print("\tEnter your username: ");
		String username = scanny1.nextLine();
		System.out.println();
		System.out.print("\tEnter your password: ");
		String password = scanny1.nextLine();
		System.out.println("*************************************************************************************************************************************************************************\n");
		
	}

	
}
