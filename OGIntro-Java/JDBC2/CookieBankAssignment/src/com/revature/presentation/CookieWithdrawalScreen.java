package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.BusinessLogic.MoneyStuff;
import com.revature.Exceptions.DontDoThatException;
import com.revature.interfaces.Screen;

public class CookieWithdrawalScreen implements Screen{

	@Override
	public Screen start() {
		System.out.println("Take out some cookies");
		Scanner scan = new Scanner(System.in);//making a new scanner to scan input
		System.out.println("Enter the amount of cookies you want to take out");
		int amt = scan.nextInt(); //scans to take the input of how much they want to withdraw
		
		try {
			MoneyStuff.recieveCookies(amt);
		} catch (DontDoThatException e) {
			// TODO Auto-generated catch block
			System.out.println("Overdraft Protection Activated");
		}//I can use this here because it's static "."
		catch(InputMismatchException e) {
			System.out.println("please enter numbers only");
			return this.start();
		}
		
		
		return new MainMenu().start();
		
	}

}
