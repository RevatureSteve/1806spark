package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.BusinessLogic.MoneyStuff;
import com.revature.interfaces.Screen;

public class CookieDepositScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Store your cookies for safe keeping");
		System.out.println("Enter the amount of cookies you're storing");	
		try {
		int amt = (int) scan.nextInt();
		MoneyStuff.depositCookies(amt);
		}catch(InputMismatchException e) {
			System.out.println("please enter numbers only");
			return this.start();
		}
		
		return new MainMenu().start();
				
	}

}
