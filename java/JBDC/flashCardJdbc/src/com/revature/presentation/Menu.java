package com.revature.presentation;

import java.util.Scanner;

import com.revature.pojo.FlashCard;

public class Menu {
	
	public static void welcome() {
		System.out.println("-----------hello------------");
		System.out.println("---welcome to flashcards---");
		System.out.println("----------------------------");
	}
	
	public static FlashCard createFlashCardmenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Creating flas card!!!");
		System.out.println("enetr flash card question:");
		String question = scan.nextLine();
		System.out.println("enter flash card card answer:");
		String answer = scan.nextLine();
		System.out.println();
		
		FlashCard fc = new  FlashCard(0, question, answer);
		return fc; 
	}

}
