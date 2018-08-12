package com.revature.presentation;

import java.util.Scanner;

import com.revature.pojo.FlashCard;

public class Menus {
public static void welcome() {
	System.out.println("welcome there hey there oh yeah there");
}

public static FlashCard createFlashCardMenu() {
	Scanner scan = new Scanner(System.in);
	System.out.println("Creating a flashcard");
	System.out.println("enter flashcard question: ");
	String question = scan.nextLine();
	System.out.println("enter flashcard answer: ");
	String answer = scan.nextLine();
	
	FlashCard fc = new FlashCard(0, question, answer); 
	
	return fc;
}
}
