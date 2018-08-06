package com.revature.bank;

import java.util.Scanner;

import com.revature.bank.pojo.Bank_AccountPojo;
import com.revature.bank.pojo.UsersPojo;
import com.revature.bank.UserPassImpl;
import com.revature.bank.Dao.UserPassDao;


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
	
	
//take user input for bank deposit
	
		public static void bankDeposit() {
			

			UserPassImpl deposit = new UserPassImpl();
			
			
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				System.out.println("Please enter your user id (future acct#): ");
				int id = scan.nextInt();
				
				System.out.println("Enter amount of deposit: ");
				double amount = scan.nextDouble();
				
				deposit.bankDeposit(id, amount);
				
				System.out.println("Thank You for your deposit, ");
				System.out.println("This money will be used to fund Queen Cersei's war!");
				
				
				BankPresentationUtil.mainMenu();
				
			}
				
			}

				
//take user input for bank withdraw
	
		public static void bankWithdraw() {
			

			UserPassImpl withdraw = new UserPassImpl();
			
			
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				System.out.println("Please enter your user id (future acct#): ");
				int wNum = scan.nextInt();
				
				System.out.println("Enter amount of withdraw: ");
				double wAmount = scan.nextDouble();
				
				wAmount = -wAmount;
				
				withdraw.bankDeposit(wNum, wAmount);
				
				System.out.println("Are you sure you don't need more? ");
				System.out.println("WINTER IS COMING!");
				
				
				BankPresentationUtil.mainMenu();
				
			}
				
			}

		
		
		
		public static void getBalance() {
			
			UserPassDao userBalance = new UserPassImpl();
			
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				System.out.println("Enter user id to check your balance: ");
				int uid = scan.nextInt();
		
		System.out.println("Your current Balance is: ");
         System.out.println(userBalance.viewBalance(uid).getBalance() + " Golden Dragons");
            
         BankPresentationUtil.mainMenu();
				
			}
		}

	

	
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
				BankPresentationUtil.getBalance();
				break;
			case 3:
				bankDeposit();
				break;
			case 4:
				bankWithdraw();
				break;
			
			}
			
		}

	}
	
//	public static

}
