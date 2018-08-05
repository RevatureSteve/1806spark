package com.revature.bl;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;
import com.revature.presentation.DepositScreen;
import com.revature.Screen;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;

public class BL {

	static BankDao bd = new BankDaoImpl();

	public static Boolean validateUser(String username, String password) {
		Users user = Users.getUser();
		if (bd.getUsersByUsername(username) != null) {
			if (user.getPassword().equals(password)) {
				System.out.println("Welcome " + user.getFname());
				return true;
			}
		}
		return false;
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
		}
		bd.withdrawFromBankAccount(amt, accNum);
		return true;
	}

}
