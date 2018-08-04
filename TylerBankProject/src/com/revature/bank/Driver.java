package com.revature.bank;

import java.util.Scanner;

import com.revature.bank.pojo.UsersPojo;

public class Driver  {
	
	private static final String USERNAME= "bank_db";
	private static final String PASSWORD= "p4ssw0rd";
	private static final String URL= "jdbc:oracle:thin:@tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com:1521:ORCL";

	public static void main(String[] args) {


	//Scanner scan = new Scanner(System.in);
	
	
	
    UsersPojo user = BankPresentationUtil.loginSwitch();
	
    System.out.println(user.getFname() + " " + user.getLname());
    /*
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
		*/
	
	}

}

