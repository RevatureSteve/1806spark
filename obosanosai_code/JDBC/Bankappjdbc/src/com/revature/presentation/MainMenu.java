package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.interfaces.Screen;
import com.revature.pojo.BankAccount;
import com.revature.pojo.User;
import com.revature.services.Service;

public class MainMenu implements Screen {
	
	@Override
	public Screen start() {
		
		Scanner scan = new Scanner(System.in);
		
		User PresentUser = User.getPresentUser();
		System.out.println("                     ");
     	System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Hello! " + PresentUser.getFirstName() + " " + PresentUser.getLastName()+ "+ +");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("                       ");
		Service.applyUserAccount(PresentUser.getUserId());
		System.out.println(BankAccount.getPresentAccount());
		
		System.out.println("                               ");
		System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
		System.out.println("+ How may i NOT be of service +");
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>");
		System.out.println("                        ");
		System.out.println("Shoot 1: + Deposit a Chimichanga + ");
		System.out.println("Shoot 2: + Steal a Chimichanga or two +");
		System.out.println("Shoot 3: + Spy on previous Chimichanga transactions +");
		System.out.println("Shoot 4: + Logout/killshot +");
		System.out.println("Shoot 5: Leaving sister magret's...");
		
		try {
			int userInput = scan.nextInt();
		
			switch (userInput) {
				case 1:
					return new Deposit().start();
				case 2:
					return new Withdrawal().start();
				case 3:
					return new ViewTx().start();
				case 4:
					System.out.println("User is logging out...");
					return new Login().start();
				case 5:
					System.out.println("Leaving sister magret's...");
					System.exit(1);
				}
		} catch (InputMismatchException e) {
			System.out.println("                                      ");
			System.out.println("Choose from the options below or don't");
			System.out.println("                                      ");
		}
		
		
		
		return this.start();
		
	}

}
