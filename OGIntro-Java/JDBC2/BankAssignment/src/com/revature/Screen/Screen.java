package com.revature.Screen;

import java.util.Scanner;

import com.revature.Pojos.User;

public class Screen {
	//Takes user input
	private static Scanner scan = new Scanner(System.in);
	
	public static User login() {
		System.out.println("Enter Username"); 
		String usename = scan.nextLine(); //takes in username input
		System.out.println("Enter Password");
		String pw = scan.nextLine(); // takes in password input
		User you = new User(0, usename, pw); //creates new user object
		return you;
		
	}
	
	public static void YourMainMenu() { // main menu
		System.out.println("YOU'RE IN, IT'S COOKIE TIME!!!");
		System.out.println("Enter 1 to see how many cookies you have"); // view balance
		System.out.println("Enter 2 to add more cookies"); // deposit
		System.out.println("Enter 3 to eat some cookies"); //withdrawal
		String CookieInput = scan.nextLine(); // takes input
	}
	
	public static void Deposit() { // if they press 2
		System.out.println("How many cookies do you want to add"); // deposit amount
		System.out.println("Type 'exit' in order to exit"); // back to YourMainMenu
		String DepositInput = scan.nextLine(); //takes deposit amount
		switch (DepositInput) {
		case "exit": //if they type exit
			YourMainMenu(); // take them back to the main menu
		
		default:
			System.out.println(DepositInput + "cookies have been entered into your cookie bank");
		}//lets them know how many cookies have been entered into the cookie bank
	}
	
}
