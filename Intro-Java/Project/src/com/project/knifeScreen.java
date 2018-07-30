package com.project;

import java.util.Scanner;

public class knifeScreen implements Interface{
		private Scanner scan = new Scanner(System.in);
		
		
		
		public Interface start() {
			// TODO Auto-generated method stub
			System.out.println("Select a Cutter");
			System.out.println("1. Sharpen");
			System.out.println("2. Change Blade.");
			System.out.println("3. Return");
			String input = scan.nextLine();
		
		switch (input) {
		case "1":
			return 
					canChangeBlade() {
				// TODO Auto-generated method stub
				
			}
		
		case "2":
		return 
		

		case "3":
		System.out.println("You cannot wield it.");
		break;
		}
		return new MainScreen();
		}



		@Override
		public void sharpenBlade() {
			// TODO Auto-generated method stub
			
		}



		
	}

