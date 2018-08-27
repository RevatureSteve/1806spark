package com.bank;

import java.util.Scanner;

import com.bank.pojos.User;

public class Driver {

	public static void main(String[] args) {
		System.out.println("****************************************");
		System.out.println("            Welcome to Bingo Bank \n            Please sing in");
		System.out.println("****************************************");
		System.out.println("Please enter username:");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		
		
		System.out.println("Welcome back " + username + " " +  password + "!!!");
		User us = new User();
		us.getFirst_name();
		System.out.println("What would you like to do?");
		System.out.println("Enter 1. See balance");
		System.out.println("Enter 2. Withdraw");
		System.out.println("Enter 3. Deposit");
		System.out.println("Enter 4.Transaction History");
	}

}
