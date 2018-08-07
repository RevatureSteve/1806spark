package com.revature.presentation;

import java.util.Scanner;

import com.revature.BusinessLogic.MoneyStuff;
import com.revature.interfaces.Screen;

public class CookieDepositScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Store your cookies for safe keeping");
		System.out.println("Enter the amount of cookies you're storing");	
		int amt = (int) scan.nextInt();
		MoneyStuff.depositCookies(amt);
		return new MainMenu().start();
				
	}

}
