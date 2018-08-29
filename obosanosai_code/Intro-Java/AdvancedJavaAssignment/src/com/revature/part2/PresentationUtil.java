package com.revature.part2;

import java.util.Scanner;

import com.revature.Shirts;
import com.revature.abstracts.Clothes;

public class PresentationUtil {
 
	public static void welcomeMenu() {
	 System.out.println("Welcome, please select from the list below:");
     System.out.println("Enter 1 for selecting clothes");
     System.out.println("Enter 2 for reading the current list of clothes");
     System.out.println("Enter 3 to exit");
	
}
	
	public static Clothes creatingNewClothes() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----New Clothes-----");
		System.out.println("Enter Color: ");
		String clotColor = scan.nextLine();
		System.out.println("Enter Size: ");
		int clotSize = scan.nextInt();
		
		Clothes clot = new Shirts( clotSize, clotColor);
		//scan.close();
		return clot;
		
 }
	public static void presentStudent(Clothes clot) {
		System.out.println("-----Current Student-----");
		System.out.println(clot);
	}
	
	public static void errorView(String message) {
		System.out.println("Sorry something went wrong...");
		System.out.println(message);
	}

	public static void presentClothes(Clothes clot) {
		
		
	}

	
	}


