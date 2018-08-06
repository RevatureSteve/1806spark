package com.revature.assign;

import java.util.Scanner;

public class Screen {
	
	public static void startScreen() {
		System.out.println("Main menu");
		System.out.println("Press 1 to create Label using serialization");
		System.out.println("Press 2 to read LabelSheet using serialization");
		System.out.println("Press 3 to create Label using bufferedwriter");
		System.out.println("Press 4 to read LabelSheet using bufferedwriter");		
		System.out.println("Press 5 to exit");
	}
	
	public static LabelB newLabelB() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("New Label");
		
		System.out.println("Please enter age");
		String labelName = scan.nextLine();
		
		System.out.println("Please enter level of aggression between 1 - 10");
		int attackLevel = scan.nextInt();
		
		LabelB label = new LabelB(labelName, attackLevel);
		
		return label;
	}
	
	public static void displayLabelB(LabelB label) {
		System.out.println("Displaying LabelB");
		System.out.println(label);
	}

}
