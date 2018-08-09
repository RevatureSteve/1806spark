package com.revature.pojo;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.database.DataBankDoa;
import com.revature.database.Doa;

public class ToolCool {
//original UserLogin


	public static void welcome() {
 
		System.out.println("**********************************");
		System.out.println("**                              **\n");

		System.out.println("* Welcome to \"CHESTER'S!!!\" Banking *");
		System.out.println("**                              **\n");
		System.out.println("**                              **\n");
		System.out.println("**                              **\n");
		System.out.println("**  A Brain Foggy Day           **\n");

		System.out.println("**********************************\n");

	}


	public static Users login() {

		Doa bank = new DataBankDoa();
//  

		Users user = null;

		String username = "";

		String password = "";

		Scanner scan = new Scanner(System.in);
// warning scan is never closed check it out chester!!!


		do{

		System.out.println("Enter Username");

		username = scan.nextLine();



		System.out.println("Enter Password");

		password = scan.nextLine();

		

		user = bank.confirmUser(username, password);

		} while(user == null);

		

		return user;

	}



	public static void someMenu() {
 
		System.out.println("What would you like you do?");

		System.out.println("Please choose from one of the options below.\n");

		System.out.println("Press 1 to Deposit Money");

		System.out.println("Press 2 to Withdraw Money");

		System.out.println("Press 3 for Available Balance");

		System.out.println("Press 4 to Log Out & Exit");

	}



	public static void deposit(int usersId) {
		
		Doa bank = new DataBankDoa();
try {
		bank.getAccountInfo(usersId);
		@SuppressWarnings("resource") // ad suppress warning to resource 
	
		Scanner scan = new Scanner(System.in);



		System.out.println("How much to Deposit TodaY?");

		double depositAmount = scan.nextDouble();
		Account account  = Account.accountSingleton();
		
		Users forBank = Users.getInstance();
		bank.setDepositAmount(account.getAccountNumber(), depositAmount);
//		bank.getAccountInfo(forBank.getUsersId()) 
	} catch (InputMismatchException e){
		System.out.println("please try again");
		}
	}



	public static void withdraw(int usersId) {
	try {	Account account = Account.accountSingleton();

		Doa bank = new DataBankDoa();

		bank.getAccountInfo(usersId);
		
		Scanner scan = new Scanner(System.in);



		System.out.println("How much would you like withdraw?");
		
		
		double withdrawAmount = scan.nextDouble();
              if(withdrawAmount > account.getBalance() ) {
            	  withdrawAmount = 0;
            	  System.out.println("Cannot take out more than you have ");
            	  if(withdrawAmount < account.getBalance()) {
            		  System.out.println("So, you cannot overDraft your Account");
            		  withdrawAmount = 0;
            		  
            		  System.out.println("You can add overDraft protection to your Account to avoid purchase Decline!");
            	  }
              }
		//bank.setWithdrawAmount(usersId, withdrawAmount);
		Users forBank = Users.getInstance();
		//bank.setDepositAmount(account.getAccountNumber(), withdrawAmount);
		bank.setWithdrawAmount(account.getAccountNumber(), withdrawAmount);

	} catch(InputMismatchException e) {
		System.out.println("please try again");
		}
	}



}
