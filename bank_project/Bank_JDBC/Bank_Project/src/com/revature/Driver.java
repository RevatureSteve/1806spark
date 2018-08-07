package com.revature;

import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.dao.UserDao;
import com.revature.present.LoginScreen;

public class Driver {

	public static void main(String[] args) {
		System.out.println("******************************");
		System.out.println("**Welcome to Traveler's Bank**");
		System.out.println("******************************");
		
		
//		UserDao users = new UserDao();
//		List<Object> userList = users.read();
//		System.out.println(userList);
		
//		BankAccountDao bankaccounts = new BankAccountDao();
//		List<Object> bankList = bankaccounts.read();
//		System.out.println(bankList);
		
		
		new LoginScreen().start();
	}

}
