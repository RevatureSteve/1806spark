package Presentation;

import java.util.Scanner;

import com.revature.dao.BankDaoImpl;
import com.revature.exceptions.userNotFound;
import com.revature.pojo.Bank_Account;
import com.revature.pojo.Users;

public class MainMenus {

	public static void welcomeMenu() {
		System.out.println("*****************************************************************");
		System.out.println("******************Welcome to Alex's Farmers Bank*****************");
		System.out.println("*****************************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("Enter 1 to register");
		System.out.println("Enter 2 to log in");
		System.out.println("Enter 3 to exit");
	}

	public static Users createUserCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Enter a Username: ");
		String username = scan.nextLine();
		System.out.println("---Enter a Password: ");
		String password = scan.nextLine();
		System.out.println("---Enter your Firstname: ");
		String firstname = scan.nextLine();
		System.out.println("---Enter your Lastname: ");
		String lastname = scan.nextLine();
		Users ui = new Users(username, password, firstname, lastname);
		BankDaoImpl x = new BankDaoImpl();
		x.createUser(ui); // This allows me to access the createUser method inside BankDaoImpl();

		return ui;
	}

	public static Users logInscreen() {
		Users un = null;
		for (int z = 10; z >= 10; z--) {

			Scanner scan = new Scanner(System.in);
			System.out.println("---------Log in--------");
			System.out.println("");
			System.out.println("");
			System.out.println("Username: ");
			String username = scan.nextLine();
			System.out.println("Password: ");
			String password = scan.nextLine();
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("------------------------Please wait, securing your log in...-------------------------");
			BankDaoImpl x = new BankDaoImpl();

			try {
				un = x.getUserByUsername(username);

			} catch (userNotFound e) {
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println(
						"There is no record under that username... Please try again or register an account before signing in :) ");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("You have " + z + " chances before you are taken to the main menu...");
			}

			if (un != null) {
				if (un.getPassword().equals(password)) { // If the user's password stored in the database equals to the
															// password
					// the user input

				} else {
					System.out.println();
					System.out.println("Oppsss! wrong password, please try again");
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
		System.out.println(
				"*******************************************************************************************************");
		System.out.println(
				"*******************************************************************************************************");
		System.out.println(
				"****************************                                                ***************************");
		System.out.println(
				"****************************                                                ***************************");
		System.out.println("****************************     Welcome " + a.getFirstname() + " " + a.getLastname()
				+ " to ----- bank!   ***************************");
		System.out.println(
				"****************************                                                ***************************");
		System.out.println(
				"****************************                                                ***************************");
	
		System.out.println("");
		System.out.println("");
		System.out.println("1: Deposit ");
		System.out.println("");
		System.out.println("");
		System.out.println("2: Withdraw ");
		System.out.println("");
		System.out.println("");
		System.out.println("3: View Transaction ");
		System.out.println("");
		System.out.println("");
		System.out.println("4: Sign out ");

		int userInput = scan.nextInt();

		return userInput;
	}

	public static int depositScreen(Users a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------Deposit---------------------------");
		System.out.println("Enter the amount that you would like to deposit:    ");

		int amount = scan.nextInt();

		return amount;
	}

	public static int withdrawScreen(Users a) {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------Withdraw---------------------------");
		System.out.println("Enter the amount that you would like to withdraw");
		BankDaoImpl x = new BankDaoImpl();
		Bank_Account c = x.getBalance(a);
		int withdraw = scan.nextInt();

		if (withdraw > c.getBalance()) {
			withdraw = 0;
			System.out.println(
					"                                                  Insuffcient funds to withdraw, please try again later...                                   ");
		} else {
		}
		return withdraw;
	}

	public static void viewBalance(Bank_Account b) {
		Scanner scan = new Scanner(System.in);

		System.out.println("---------------------------Your Balance---------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("-----------------------" + b.getBalance() + "-----------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Press enter to go back");
		System.out.println("");
		System.out.println("Press e to exit");
		scan.nextLine();
		if (scan.nextLine() == "e") {
			System.out.println("Goodbye! We hope to see you soon!");
			System.exit(0);
		} else {

		}
	}

	public static void viewTransactionScreen() {
		System.out.println("---------------------------Transaction History---------------------------");
	}

	public static void signOutScreen() {
		System.out.println("---------------------------Signining Out---------------------------");
	}

}
