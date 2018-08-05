package com.revature.bank.presentation;

import java.util.Scanner;

import com.revature.bank.dao.BankDao;
import com.revature.bank.exceptions.NoInputException;
import com.revature.bank.pojo.User;

public class Presentation {

	// scanner used to take user inpuSt
	private static Scanner scan = new Scanner(System.in);

	public static User login() throws NoInputException{
		System.out.println("Whats your Username? ");
		String uname = scan.nextLine();
		System.out.println("and your Password? ");
		String pass = scan.nextLine();
		User u = new User(0, "", "", uname, pass);
		return u;
	}

	public static String UserMainMenu() {
		System.out.println("How may I help you?:");
		System.out.println("1 to view balance");
		System.out.println("2 to make a deposite");
		System.out.println("3 to make a withdrawl");
		System.out.println("x to leave");
		String input = scan.nextLine();
		return input;
	}

	public static String Deposit() {
		System.out.println("How much would you like to deposite (no $ symbol please):");
		String input = scan.nextLine();
		return input;
	}

	public static String Withdrawl(User u) {
			System.out.println("How much would you like to withdraw (no $ symbol please):");
			System.out.println("You currently have: $" + u.getBalance());
			String input = scan.nextLine();
			return input;
	}

	public static double ViewBalance(User u) {
		return u.getBalance();
	}
}