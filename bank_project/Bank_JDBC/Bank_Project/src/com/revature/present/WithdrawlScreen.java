package com.revature.present;

import java.util.Scanner;

import com.revature.buisnesslogic.BuisnessLogic;
import com.revature.interfaces.Screen;

import oracle.net.ns.MarkerPacket;

public class WithdrawlScreen implements Screen{

	@Override
	public Screen start() {
		System.out.println("Make a withdrawl");
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter the amount you wish to withdrawl: ");
		Double amount = scan.nextDouble();
		BuisnessLogic.makeWithdrawl(amount);
		
		
		
		
		return new MainMenuScreen().start();
	}

}
