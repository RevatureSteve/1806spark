package com.project;
import java.util.Scanner;
public class MainScreen implements Interface {

	private Scanner scan = new Scanner(System.in);

	@Override
	public Interface start() {
		// TODO Auto-generated method stub
		System.out.println("Select a Cutter");
		System.out.println("1. Knife");
		System.out.println("2. Chainsaw");
		System.out.println("3. Laser");
		String input = scan.nextLine();
	
	switch (input) {
	case "1":
		return new knifeScreen();
	
	case "2":
	return new sawScreen();
	

	case "3":
	System.out.println("You cannot wield it.");
	break;
	}
	return this;
	}
}
