package com.revature.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bank.pojo.Bank_AccountPojo;
import com.revature.bank.pojo.UsersPojo;
import com.revature.bank.UserPassImpl;
import com.revature.bank.Dao.UserPassDao;


public class BankPresentationUtil {
	
	public static UserPassImpl userDao = new UserPassImpl();
	

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
	
		public static void bankDeposit() throws BankException {
			

			UserPassImpl deposit = new UserPassImpl();
			
			
			Scanner scan = new Scanner(System.in);
		
		
			while (true) {
				System.out.println("Please enter your 4 digit account number ####: ");
			try {
				int id = scan.nextInt();
			
				System.out.println("Enter amount of deposit: ");
				double amount = scan.nextDouble();
				
				if(amount < 0) {
					throw new BankException("You can not deposit a negative amount");
				}
				
				deposit.bankDeposit(id, amount);
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please use only numbers");
				BankPresentationUtil.mainMenu();
			}
				
				System.out.println("Thank You for your deposit, ");
				System.out.println("This money will be used to fund Queen Cersei's war!");
			
			
				
				BankPresentationUtil.mainMenu();
				
			}
		}
				
			

				
//take user input for bank withdraw
	
		public static void bankWithdraw() throws BankException {
			

			UserPassImpl withdraw = new UserPassImpl();
			UserPassDao userBalance = new UserPassImpl();
			
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				System.out.println("Please enter your account number to make a withdraw: ");
				int wNum = scan.nextInt();
				
				System.out.println("Enter amount of withdraw: ");
				double wAmount = scan.nextDouble();
				
				if(wAmount < 0) {
					throw new BankException("Please Enter a positive Value");
				}
				
				wAmount = -wAmount;
				
				if (userBalance.viewBalance(wNum).getBalance() > Math.abs(wAmount)) {
					
					withdraw.bankDeposit(wNum, wAmount);
				}else {
					System.out.println("You do not have enough gold");
					System.out.println("balane test is: "+userBalance.viewBalance(wNum).getBalance());
					System.out.println("amount test " + wAmount);
				}
				
				
				
				System.out.println("Are you sure you don't need more? ");
				System.out.println("WINTER IS COMING!");
				
				
				BankPresentationUtil.mainMenu();
				
			}
				
			}

		
		
		
		public static double getBalance() {
			
			UserPassDao userBalance = new UserPassImpl();
			
			Scanner scan = new Scanner(System.in);
			
			double amt = 0.0;
			
			while (true) {
				System.out.println("Enter your account number to check your balance: ");
				int uid = scan.nextInt();
		
		System.out.println("Your current Balance is: ");
         System.out.println(userBalance.viewBalance(uid).getBalance() + " Golden Dragons");
            
         BankPresentationUtil.mainMenu();
         return userBalance.viewBalance(uid).getBalance();
     	
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
				try {
					bankDeposit();
				} catch (BankException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					bankWithdraw();
				} catch (BankException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			}
			
		}

	}
	
//	public static

}
