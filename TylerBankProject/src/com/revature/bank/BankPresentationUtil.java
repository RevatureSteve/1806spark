package com.revature.bank;

import java.util.Scanner;

import com.revature.bank.pojo.Bank_AccountPojo;
import com.revature.bank.pojo.UsersPojo;
import com.revature.bank.UserPassImpl;


public class BankPresentationUtil {
	
	public static UserPassImpl userDao = new UserPassImpl();
	
//	public static void userLogin() {
//		System.out.println("1 to Enter Username");
//		System.out.println("2 to Enter Password");
//		System.out.println("3 to Register");
//		System.out.println("4 to return to Main Menu");
//	}
//	
	public static UsersPojo loginSwitch() {
		
		UsersPojo user = new UsersPojo();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		System.out.println("Enter Username: ");
		String userName = scan.nextLine();
		
		System.out.println("Enter Password");
		String userPass = scan.nextLine();
		
		user.setUsername(userName);
		user.setPassword(userPass);
		
		if(userDao.verifyUsernameAndPassword(user)) {
			return user;
		}else {
			System.out.println("Invalid Login, please enter information again...");
		}
		}

		
	}
	
	
		
		public static void bankDeposit() {
			
//			Bank_AccountPojo deposit = new Bank_AccountPojo();
			UserPassImpl deposit = new UserPassImpl();
			
			
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				System.out.println("Please enter your user id (future acct#): ");
				int id = scan.nextInt();
				
				System.out.println("Enter amount of deposit: ");
				double amount = scan.nextInt();
				
				deposit.bankDeposit(id, amount);
				
			}
				
			}

				
//			}
	

	
	public static void mainMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Enter 1 to Logout");
			System.out.println("Enter 2 View Balance");
			System.out.println("Enter 3 Deposit");
			System.out.println("Enter 4 Withdraw");
			System.out.println("-------------------------------------------------------------------");
			
			int userInput = scan.nextInt();
			
			
			
			switch (userInput) {
			case 1:
				System.out.println("logout successful");
				System.exit(1);
				break;
			case 2:
				System.out.println("Heres your Balance");
				break;
			case 3:
				bankDeposit();
				break;
			case 4:
				System.out.println("Withdrawl completed, your balance is");
				break;
			
			}
			
		}

	}
	
//	public static

}
