package com.revature.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.exceptions.WrongInputException;
import com.revature.pojo.BankAccount;
import com.revature.pojo.BankTransaction;
import com.revature.pojo.Users;

public class BusinessLogic {

	static BankDao bd = new BankDaoImpl();

	// Validate username and password for login
	public boolean validateLogin(String username, String password) {
		Users user = Users.getUser();
		if (bd.getUsersByUsername(username) != null) {
			if (user.getPassword().equals(password)) {
				System.out.println();
				return true;
			}
		}
		return false;
	}

	// Validate whether the username exists somewhere in the db
	public boolean validateUsername(String username) {
		Users user = Users.getUser();
		if (bd.getUsersByUsername(username) == null && username != "") {
			System.out.println(username + " is acceptable!");
			return true;
		} else {
			System.out.println(username + " is taken, please try another username!");
			return false;
		}
	}

	// After user creation, get the id for the user singleton
	public static void getUserIdByUsername() {
		Users user = Users.getUser();
		try {
			bd.getUsersByUsername(user.getUsername());
		} catch (Exception e) {
			System.out.println("There was an issue on our side we apologize for the inconvenience");
		}
	}

	// checks to see if there is a negative value in the user input before
	// depositing amt
	public static boolean depositToAccount(double amt, int accNum) {

		if (amt < 0) {
			System.out.println("You cannot deposit a negative value, please try again");
			return false;
		} else {
			bd.depositToBankAccount(amt, accNum);
			return true;
		}
	}

	// checks if user is overdrafting, as well as withdrawing a negative amount
	public boolean withdrawFromAccount(double amt, int accNum) {

		BankAccount ba = bd.getBankAccountInfo(Users.getUser().getId());
		if (ba.getBalance() - amt < 0) {
			System.out.println("You are overdrafting from your account");
			System.out.println("Please enter a new amount");
			return false;
		} else if (amt < 0) {
			System.out.println("You cannot withdraw a negative amount");
			return false;
		} else {
			bd.withdrawFromBankAccount(amt, accNum);
			return true;
		}
	}

	// gets users transaction history and puts it in a list
	public static List<BankTransaction> getTransactionHistory(int accNum) {
		return bd.getBankTransactions(accNum);
	}

	// checking the users input for a none double input
	public double checkDoubleInputException() {
		Scanner scan = new Scanner(System.in);
		double amount = 0;
		try {
			amount = scan.nextDouble();
		} catch (WrongInputException e) {
			System.out.println("You did not input a number.");
			System.out.println("Please try again");
		} catch (RuntimeException e) {
			System.out.println("You did not input a number.");
			System.out.println("Please try again");
		} catch (Exception e) {
			System.out.println("You did not input a number.");
			System.out.println("Please try again");
		}
		return amount;

	}

}
