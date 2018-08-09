package com.revature.presentation;

import java.util.Scanner;

import com.revature.pojo.FlashCard;

public class Screens {

	public static void welcome() {
		System.out.println("*************************");
		System.out.println("* Welcome to FlashCards *");
		System.out.println("*************************");		
	}
	
	public static FlashCard createFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Create a FlashCard---");
		System.out.println("Question:");
		String question  = scan.nextLine();
		System.out.println("Answer:");
		String answer = scan.nextLine();
//		scan.close();
		
		return new FlashCard(0,question,answer);
	}

}
