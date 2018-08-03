package com.revature.presentation;

import java.util.Scanner;

import com.revature.pojos.FlashCard;

public class Menus {
	public static void welcome() {
		System.out.println("*************");
		System.out.println("Welcome to FlashCards");
		System.out.println("*************");
	}
	
	public static FlashCard createFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("----Creating a Flashcard----");
		System.out.println("What is your question?");
		String question = scan.nextLine();
		System.out.println("What is your answer?");
		String answer = scan.nextLine();
		FlashCard fc = new FlashCard(0, question, answer);
		return fc;
		
		
	}
}
