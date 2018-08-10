package com.revature.bank.presentation;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.revature.bank.exceptions.NegativeInputException;
import com.revature.bank.pojo.User;

public class Presentation {

	//scanners for input
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan2 = new Scanner(System.in);

	public static void intro() {
		Flowey.Smile();
		System.out.println("Well Howdy! Welcome to my bank!");
		System.out.println("Or welcome back, I'm not good with faces.");
		System.out.println("Before we can begin I will need to know your account information.");
	}

	public static User login() {
		String uname, pass = null;
		while (true) {
			System.out.println("whats your username?");
			uname = scan.nextLine();
			if (uname.length() == 0) {
				Flowey.uh();
				System.out.println("uhhh, You know I kinda need that information in order to get your account.");
				continue;
			}
			System.out.println("and your Password? ");
			pass = scan.nextLine();
			if (pass.length() == 0) {
				Flowey.uh();
				System.out.println("uhhh, You know I kinda need that information in order to get your account.");
				continue;
			}
			break;
		}
		User u = new User(0, "", "", uname, pass);
		return u;
	}

	public static String UserMainMenu() {
		System.out.println("How may I help you?:");
		System.out.println("1 to view balance");
		System.out.println("2 to make a deposite");
		System.out.println("3 to make a withdrawl");
		System.out.println("x to leave");
		String input = scan.nextLine();
		return input;
	}

	public static String Deposit() throws NegativeInputException {
		while (true) {
			Flowey.Smile();
			System.out.println("How much would you like to deposite (no $ symbol please):");
			String input = scan.nextLine();
			if (Double.parseDouble(input) < 0) {
				boolean sure = Presentation.Negative();
				if (sure == true) {
					throw new NegativeInputException();
				} else {
					Flowey.Smug();
					System.out.println("Thats what I thought. lets try this again.");
					continue;
				}
			}
			return input;
		}
	}

	public static String Withdrawl(User u) throws NegativeInputException {
		while (true) {
			Flowey.Smile();
			System.out.println("How much would you like to withdraw (no $ symbol please):");
			System.out.println("You currently have: $" + u.getBalance());
			String input = scan.nextLine();
			if (Double.parseDouble(input) < 0) {
				boolean sure = Presentation.Negative();
				if (sure == true) {
					throw new NegativeInputException();
				} else {
					Flowey.Smug();
					System.out.println("Thats what I thought. lets try this again.");
					continue;
				}
			}
			return input;
		}
	}

	public static boolean ViewBalance(double bal, boolean sceneCheck) {
		Flowey.Smile();
		System.out.println("Your balance is: $" + bal);
		if(!sceneCheck) {
			System.out.println("(enter to continue)");
			scan.nextLine();
			Flowey.uh();
			System.out.println("Huh? Its lower than you remember having?");
			System.out.println("(enter to continue)");
			scan.nextLine();
			Flowey.Side2();
			System.out.println("Nonsence! I assure you your money is safe with me!");
			return true;
		}
		return false;
	}

	public static boolean Negative() {
		Flowey.Smug();
		System.out.println("Oh really? Your gonna be that person?");
		System.out.println(
				"Are you sure you want to do that? Cause I will give it a try but you probably wont like what happens.");
		System.out.println("1 for yes, anything else for no");
		int sure = scan2.nextInt();
		if (sure == 1) {
			Flowey.intimidate();
			System.out.println("Are you really sure you want to do that?");
			System.out.println("1 for yes, anything else for no");
			sure = scan2.nextInt();
			if (sure == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean Negative2(boolean sceneCheck) {
		Flowey.Smug();
		System.out.println("**com.revature.bank.exceptions.NegativeInputException**");
		System.out.println("Oh would you look at that...");
		System.out.println("You know, most people dont like it when you try to break their stuff.");
		System.out.println("Lucky for you Iv'e idiot proofed this bank.");
		System.out.println("(enter  to continue)");
		scan.nextLine();
		Flowey.Side();
		System.out.println("Still though, it would be much appreciated if you dont try to do that. anyways,");
		if(!sceneCheck) {
			return true;
		}
		return false;
	}
	
	public static void Hacker() {
		Flowey.Annoyed();
		System.out.println("Ok enough. Clearly you dont have an account here so what are you trying to do?");
		System.out.println("(enter to continue)");
		scan.nextLine();
		Flowey.Smug();
		System.out.println("Oh I see whats going on. You are trying to hack your way into an account arnt ya?");
		System.out.println("(enter to continue)");
		scan.nextLine();
		Flowey.Smile();
		System.out.println("Well I certainly can't have you taking away my vacation mon...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
		Flowey.Side();
		System.out.println("I mean all my customer's money.");
		scan.nextLine();
		System.out.println();
		System.out.println();
		Flowey.Smug();
		System.out.println("aaaaanyways. goodye!");
		System.exit(0);
	}
	public static void exit(boolean sceneCheck) {
		Flowey.Smile();
		System.out.println("Ok. thank you for stopping by!");
		if(sceneCheck==true) {
			System.out.println("(enter to continue)");
			scan.nextLine();
			Flowey.Smug();
			System.out.println("And I better not see you causing any more trouble.");
		}
		System.exit(0);
	}
}