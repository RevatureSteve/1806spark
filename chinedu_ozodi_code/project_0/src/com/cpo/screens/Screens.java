package com.cpo.screens;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cpo.SessionManager;
import com.cpo.animation.TextAnimation;
import com.cpo.beans.User;
import com.cpo.color.Colors;
import com.cpo.dao.UserDatabaseDao;

public class Screens {
	
	public static void welcome() {
		Scanner scan = new Scanner(System.in);
		TextAnimation.animate("Loading interface...", 15, 100);
		TextAnimation.blinkingCursor("Encrypting connection, securing codebase", 15, 100);
		
		TextAnimation.leftToRightText(Colors.GREEN + "Welcome to...");
		TextAnimation.topToBottomText("\r\n" + 
				" /$$$$$$$      /$$$$$$      /$$   /$$     /$$   /$$\r\n" + 
				"| $$__  $$    /$$__  $$    | $$$ | $$    | $$  /$$/\r\n" + 
				"| $$  \\ $$   | $$  \\ $$    | $$$$| $$    | $$ /$$/ \r\n" + 
				"| $$$$$$$    | $$$$$$$$    | $$ $$ $$    | $$$$$/  \r\n" + 
				"| $$__  $$   | $$__  $$    | $$  $$$$    | $$  $$  \r\n" + 
				"| $$  \\ $$   | $$  | $$    | $$\\  $$$    | $$\\  $$ \r\n" + 
				"| $$$$$$$//$$| $$  | $$ /$$| $$ \\  $$ /$$| $$ \\  $$\r\n" + 
				"|_______/|__/|__/  |__/|__/|__/  \\__/|__/|__/  \\__/\r\n" + 
				"");
		TextAnimation.blinkingCursor(Colors.GREEN + "------Big Awesome fuNds Kit (terminal edition)------" + Colors.RESET, 15, 100);
		TextAnimation.leftToRightText("1) " + Colors.GREEN + "Login" + Colors.RESET);
		TextAnimation.leftToRightText("2) " + Colors.YELLOW + "Register" + Colors.RESET);
		TextAnimation.leftToRightText("3) " + Colors.RED + "Exit" + Colors.RESET);
		
		int menuSelect = nextIntWelcome();
		
		switch(menuSelect) {
		case 1:
			login();
			break;
		case 2:
			register();
			break;
		case 3:
			scan.close();
			System.exit(1);
			break;
		default:
			TextAnimation.leftToRightText("Nope...a valid number please");
			welcome();
		}
	}

	private static void login() {
		Scanner scan = new Scanner(System.in);
		TextAnimation.topToBottomText( Colors.YELLOW_BOLD_BRIGHT+" _        ____   _____   _____   _   _   \r\n" + 
				" | |      / __ \\ / ____| |_   _| | \\ | | \r\n" + 
				" | |     | |  | | |  __    | |   |  \\| | \r\n" + 
				" | |     | |  | | | |_ |   | |   | . ` | \r\n" + 
				" | |____ | |__| | |__| |_ _| |_ _| |\\  | \r\n" + 
				" |______(_)____(_)_____(_)_____(_)_| \\_| ");
		TextAnimation.leftToRightText(" -------Let Only me Get Into fuNds------");
		TextAnimation.leftToRightText(Colors.YELLOW + "Enter codename:");
		String uName = scan.nextLine();
		TextAnimation.leftToRightText("Enter password:");
		String pWord = scan.nextLine();
		
		User user = UserDatabaseDao.getInstance().getUser(uName, pWord);
		if (user == null) {
			TextAnimation.leftToRightText("Incorrect codename or password, try again?");
			TextAnimation.leftToRightText("1) Yes!");
			TextAnimation.leftToRightText("2) Back to main menu");
			TextAnimation.leftToRightText("3) Exit");
			
			int menuSelect = nextIntWelcome();
			
			switch(menuSelect) {
			case 1:
				login();
				break;
			case 2:
				welcome();
				break;
			case 3:
				scan.close();
				System.exit(1);
				break;
			default:
				TextAnimation.blinkingCursor("I thought you were trained better than this...let's start again");
				login();
			}
		}
		else {
			SessionManager.setLoggedInUser(user);
			TextAnimation.leftToRightText("You have succeffully logged in!");
			AccountSummary.accountSummary();
		}
	}

	private static void register() {
		Scanner scan = new Scanner(System.in);
		TextAnimation.topToBottomText(Colors.YELLOW + "  _____    ______   _____   _____    _____ _______ ______   _____  \r\n" + 
				" |  __ \\  |  ____| / ____| |_   _|  / ____|__   __|  ____| |  __ \\ \r\n" + 
				" | |__) | | |__   | |  __    | |   | (___    | |  | |__    | |__) |\r\n" + 
				" |  _  /  |  __|  | | |_ |   | |    \\___ \\   | |  |  __|   |  _  / \r\n" + 
				" | | \\ \\ _| |____ | |__| |_ _| |_ _ ____) |  | |_ | |____ _| | \\ \\ \r\n" + 
				" |_|  \\_(_)______(_)_____(_)_____(_)_____(_) |_(_)|______(_)_|  \\_\\");
		TextAnimation.leftToRightText(" ------------Retain every Good Info(S) To Enter Reserve------------");
		TextAnimation.leftToRightText("Enter your first name:");
		String fName = scan.nextLine();
		TextAnimation.leftToRightText("Enter your last name:");
		String lName = scan.nextLine();
		TextAnimation.leftToRightText("Enter your username:");
		String uName = scan.nextLine();
		TextAnimation.leftToRightText("Enter your password:");
		String pWord = scan.nextLine();
		TextAnimation.leftToRightText(Colors.GREEN + "Thank you! user is being created");
		
		User user = new User(fName,lName,uName,pWord);
		
		UserDatabaseDao.getInstance().createUser(user);
		
		TextAnimation.blinkingCursor("User creation success! Redirecting to login screen");
		login();
	}
	
	public static int nextInt() {
		Scanner scan = new Scanner(System.in);
		try {
			int menuSelect = scan.nextInt();
			scan.nextLine();
			return menuSelect;
		}
		catch (InputMismatchException e ) {
			TextAnimation.blinkingCursor("You know you are supposed to enter a number agent " + SessionManager.getLoggedInUser().getUsername());
			TextAnimation.leftToRightText("Try again:");
			return nextInt();
		}
	}
	
	private static int nextIntWelcome() {
		Scanner scan = new Scanner(System.in);
		try {
			int menuSelect = scan.nextInt();
			scan.nextLine();
			return menuSelect;
		}
		catch (InputMismatchException e ) {
			TextAnimation.blinkingCursor("Who are you?");
			return nextInt();
		}
	}

}
