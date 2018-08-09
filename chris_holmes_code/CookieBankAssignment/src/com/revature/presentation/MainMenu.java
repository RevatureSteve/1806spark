package com.revature.presentation;

import java.util.Scanner;

import com.revature.BusinessLogic.MoneyStuff;
import com.revature.interfaces.Screen;
import com.revature.pojos.CookieAccount;
import com.revature.pojos.Cookieuser;

public class MainMenu implements Screen{

	@Override
	public Screen start() {
		
		Cookieuser currentcookie = Cookieuser.getCurrentCookie();//getting the current user
		
		System.out.println("Hello " + currentcookie.getFname());
		MoneyStuff.findTheAccountAltertheCookies(currentcookie.getId());
		System.out.println(CookieAccount.getCurrentAcct());
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Make a selection");
		System.out.println("Enter 1 to retrieve cookies");
		System.out.println("Enter 2 to store cookies");
		System.out.println("Enter 3 to view user info");
		System.out.println("Enter 4 to log out");
		
		int input = scan.nextInt();
		
		switch (input) {
		case 1:
			return new CookieWithdrawalScreen().start();
		case 2:
			return new CookieDepositScreen().start();
		case 3:
			return new ViewUserInfoScreen().start();
		case 4:
			System.out.println("Enjoy your cookies!");
			System.exit(1);
	
		}
		
		return this.start();
		
		}
	}


