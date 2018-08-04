package com.revature.bank;

import java.util.Scanner;

public class Driver  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Hello Please Log In");
	BankPresentationUtil.loginSwitch();
	
	BankPresentationUtil.mainMenu();
	
		while(true) {
			
			int userInput = scan.nextInt();
			
			System.out.println("Welcome to the Bank, Please Select an option");
			
			switch (userInput) {
			case 1:
				System.out.println("logout successful");
				System.exit(1);
				break;
			case 2:
				System.out.println("Heres your Balance");
				break;
			case 3:
				System.out.println("Thank's for the cash, your balance is: ");
				break;
			case 4:
				System.out.println("Withdrawl completed, your balance is");
				break;
			
			}
			
		}
	
	}

}

