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
	public static boolean validateLogin(String username, String password) {
		Users user = Users.getUser();
		if (bd.getUsersByUsername(username) != null) {
			if (user.getPassword().equals(password)) {
				System.out.println("Welcome " + user.getFname());
				System.out.println();
				return true;
			}
		}
		return false;
	}
	
	public static boolean validateUsername(String username) {
		Users user = Users.getUser();
		if (bd.getUsersByUsername(username) == null) {
			System.out.println(username + " is acceptable!");
			return true;
		}
		System.out.println(username + " is taken, please try another username!");
		return false;
	}

	
	public static void getUserIdByUsername() {
		Users user = Users.getUser();
		bd.getUsersByUsername(user.getUsername());
	}
	
	
	public static boolean depositToAccount(double amt, int accNum) {

		if (amt < 0) {
			System.out.println("You cannot deposit a negative value, please try again");
			return false;
		} else {
			bd.depositToBankAccount(amt, accNum);
			return true;
		}
	}

	public static boolean withdrawFromAccount(double amt, int accNum) {

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
	
	
	public static List<BankTransaction> getTransactionHistory(int accNum) {
		return bd.getBankTransactions(accNum);
	}
	
	
	public static double checkException() throws WrongInputException{
		Scanner scan = new Scanner(System.in);
		double amount = 0;
		try {
			amount = scan.nextDouble();
		} catch (WrongInputException e) {
			System.out.println("You did not input a number or value can't be 0.");
			System.out.println("Please try again");
		}
		catch (RuntimeException e)
		{		
			System.out.println("You did not input a number or value can't be 0.");
			System.out.println("Please try again");
		}
		return amount;
		
	}

}
