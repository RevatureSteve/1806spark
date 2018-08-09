package Presentation;

import java.util.Scanner;

import com.revature.dao.BankDaoImpl;
import com.revature.exceptions.userNotFound;
import com.revature.pojo.Bank_Account;
import com.revature.pojo.Users;

public class MainMenus {

	public static void welcomeMenu() {
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("******************                                                        *****************");
		System.out.println("******************           Welcome to the Commonwealth Bank of          *****************");
		System.out.println("******************                        Vault 101                       *****************");
		System.out.println("******************                                                        *****************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*                                                                                         *");
		System.out.println("*                                   Hello Wasterlander!                                   *");
		System.out.println("*                            What would you like to do today?                             *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                  Enter 1 to register                                    *");
		System.out.println("*                                  Enter 2 to log in                                      *");
		System.out.println("*                                  Enter 3 to exit                                        *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
	}

	public static Users createUserCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*                    Please fill out the following (if possible)                          *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---Username:                                                                            *");
		String username = scan.nextLine();
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---Password:                                                                            *");
		String password = scan.nextLine();
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---Firstname:                                                                           *");
		String firstname = scan.nextLine();
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---Lastname:                                                                            *");
		String lastname = scan.nextLine();
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*              Please wait... Creating bank account in Vault 101 very shortly             *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		Users ui = new Users(username, password, firstname, lastname);
		BankDaoImpl x = new BankDaoImpl();
		x.createUser(ui); // This allows me to access the createUser method inside BankDaoImpl();

		return ui;
	}

	public static Users logInscreen() {
		Users un = null;
		for (int z = 4; z >= 0; z--) {
			if (z == 0) {
				Scanner scan = new Scanner(System.in);
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("******************                                                        *****************");
				System.out.println("******************                      SHUTTING DOWN                     *****************");
				System.out.println("******************                                                        *****************");
				System.out.println("******************                PLEASE CONTACT OVERSEERER               *****************");
				System.out.println("******************                                                        *****************");
				System.out.println("******************                    TO BOOTUP TERMINAL                  *****************");
				System.out.println("******************                                                        *****************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				
				scan.nextLine();
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");	
				System.out.println("Property of Vault-Tec**********************************************************************");
				System.out.println("Vault-Tec Corporate Headquaters************************************************************");
				System.out.println("Washington D.C*****************************************************************************");
				System.out.println("Vault 101 Commonwealth Bank access machine*************************************************");
				System.out.println("Contact Vault Overseer for needed assistance***********************************************");
				System.out.println("*******************************************************************************************");
				System.exit(1);
			}
			Scanner scan = new Scanner(System.in);
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                --------Log in--------                                   *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			if (z == 4) {
				System.out.println("* ---Attempts                                                                             *");	
				System.out.println("*                                                                                         *");
				System.out.println("*  ** ** ** **                                                                            *");
				System.out.println("*  ** ** ** **                                                                            *");

			} else if (z == 3) {
				System.out.println("* ---Attempts                                                                             *");	
				System.out.println("*                                                                                         *");
				System.out.println("*  ** ** **                                                                               *");
				System.out.println("*  ** ** **                                                                               *");
			}else if (z == 2) {
				System.out.println("* ---Attempts                                                                             *");	
				System.out.println("*                                                                                         *");
				System.out.println("*  ** **                                                                                  *");
				System.out.println("*  ** **                                                                                  *");
			} else if (z == 1) {
				System.out.println("* ---Attempts                                                                             *");	
				System.out.println("*                                                                                         *");
				System.out.println("*  **                                                                                     *");
				System.out.println("*  **                                                                                     *");
			}
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("* ---Username:                                                                            *");
			String username = scan.nextLine();
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("* ---Password:                                                                            *");
			String password = scan.nextLine();
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("----------------------------Please wait, securing your log in...--------------------------*");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");

			BankDaoImpl x = new BankDaoImpl();

			try {
				un = x.getUserByUsername(username);

			} catch (userNotFound e) {
				
				System.out.println("*                                                                                         *");
				System.out.println("*                                                                                         *");
				System.out.println("*                                                                                         *");
				System.out.println(" ---No records found under " + username + "...                                    ");
				System.out.println("*                                                                                         *");
				System.out.println("*                                                                                         *");
				System.out.println("*                                                                                         *");
			    System.out.println("* ---Please try again or register an account before signing in                            *");
				System.out.println("*                                                                                         *");
				System.out.println("*                                                                                         *");
				System.out.println("*                                                                                         *");
				
				}

			if (un != null) {
				if (un.getPassword().equals(password)) { // If the user's password stored in the database equals to the
															// password
					// the user input

				} else {
					System.out.println("*                                                                                         *");
					System.out.println("*                                                                                         *");
					System.out.println("*                                                                                         *");
					System.out.println("* ---Oppsss! wrong password, please try again                                             *");
					logInscreen();
				}
				break;
			}
			
		}

		return un;
	}

	// Screens of the user once logged in
	public static int usersInformation(Users a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("******************                                                        *****************");
		System.out.println("                                     Welcome " + a.getFirstname() + " " + a.getLastname() + "                         ");
		System.out.println("******************                      To Vault 101                      *****************");
		System.out.println("******************                                                        *****************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---1: Deposit Caps                                                                      *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---2: Withdraw                                                                          *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---3: View Balance                                                                      *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---4: Sign out                                                                          *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		int userInput = scan.nextInt();

		return userInput;
	}

	public static int depositScreen(Users a) {
		BankDaoImpl x = new BankDaoImpl();
		Bank_Account d = new Bank_Account();
		d = x.getBalance(a);
		Scanner scan = new Scanner(System.in);
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*              ---------------------------Deposit---------------------------              *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* Vault 101                                                                    Caps: " + d.getBalance() + "");
		System.out.println("* Locker #" + d.getAccountNumber() + "                                                                            *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---How many Caps would you like to deposit?                                             *");

		int amount = scan.nextInt();
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---Depositing... Please wait                                                            *");

		return amount;
	}

	public static int withdrawScreen(Users a) {
		BankDaoImpl x = new BankDaoImpl();
		Bank_Account c = x.getBalance(a);
		c = x.getBalance(a);
		Scanner scan = new Scanner(System.in);
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*             ---------------------------Withdraw---------------------------              *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* Vault 101                                                                    Caps: " + c.getBalance() + "");
		System.out.println("* Locker #" + c.getAccountNumber() + "                                                                            *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---How many Caps would you like to withdraw                                             *");
	
		int withdraw = scan.nextInt();
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---Withdrawing... Please wait                                                           *");

		

		if (withdraw > c.getBalance()) {
			withdraw = 0;
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("* ---Insuffcient Caps to withdraw, please try again later...                              *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("*                                                                                         *");
			System.out.println("* ---If having trouble looting Caps                                                       *");
			System.out.println("*                                                                                         *");
			System.out.println("* ---Please refer to the survival guide in your pip boy for tips                          *");

		} else {
			
		}
		return withdraw;
	}

	public static void viewBalance(Bank_Account b) {
		Scanner scan = new Scanner(System.in);
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*             ---------------------------Balance----------------------------              *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("* ---You have                                                                             *");
		System.out.println("*                                                                                         *");
		System.out.println(" ---" + b.getBalance() + " Caps                                                            ");    
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*                                                                                         *");
		System.out.println("*---Press enter to go back                                                                *");
		scan.nextLine();
//		if (scan.nextLine() == "e") {
//			System.out.println("Goodbye! We hope to see you soon!");
//			System.exit(1);
//		} else {
//
//		}
	}

	public static void viewTransactionScreen() {
		System.out.println("---------------------------Transaction History---------------------------");
	}

	public static void signOutScreen() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("******************                                                        *****************");
		System.out.println("******************                       LOGGING OUT                      *****************");
		System.out.println("******************                                                        *****************");
		System.out.println("******************                        Thank you!                      *****************");
		System.out.println("******************                                                        *****************");
		System.out.println("******************     And be careful, stay away from the deathclaws      *****************");
		System.out.println("******************                                                        *****************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("******************                                                        *****************");
		System.out.println("******************                 SUCCESSFULLY LOGGED OUT                *****************");
		System.out.println("******************                                                        *****************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("*******************************************************************************************");
		System.out.println("********************************************************************Copyright of Vault.Tec*");
		scan.nextLine();
	}

}
