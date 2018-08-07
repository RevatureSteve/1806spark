package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.MainDao;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class BankAccountScreen implements Screen{
	
	@SuppressWarnings("resource")
	@Override
	public Screen Start() {
		MainDao balance = new BankAccountDaoImpl();
		//BankAccount account = balance.getBankAccountByUserId(UserId);
		Scanner scan = new Scanner(System.in);
		System.out.println("the balance page");
		System.out.println("here is the balance");
		System.out.println("enter 1 to return to users menu");
		System.out.println("enter 2 to exit");
		int input = scan.nextInt();
		
		switch (input) {
		case 1:
			return new UsersMenuScreen().Start();
		case 2:
			System.out.println("goodbye");
			System.exit(1);
		default:
			break;
		}
		return this;
	}
		
}
