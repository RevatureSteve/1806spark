package com.revature.presentation;

import java.util.Scanner;

import com.revature.BusinessLogic.MoneyStuff;
import com.revature.interfaces.Screen;

public class CookieWithdrawalScreen implements Screen {

	@Override
	public Screen start() {
		System.out.println("Take out some cookies");
		Scanner scan = new Scanner(System.in);//making a new scanner to scan input
		System.out.println("Enter the amount of cookies you want to take out");
		int amt = scan.nextInt(); //scans to take the input of how much they want to withdraw
		MoneyStuff.recieveCookies(amt);//I can use this here because it's static "."
		
		
		return new MainMenu().start();
		
	}

}
