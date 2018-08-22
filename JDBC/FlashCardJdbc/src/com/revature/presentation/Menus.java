package com.revature.presentation;

<<<<<<< HEAD
<<<<<<< HEAD
import com.revature.FlashCard;

public class Menus { // static because you don't wanna instantiate menus

	public static void welcome() {
		System.out.println();
		System.out.println();
		System.out.println();
	}
	public static void createFlashCardmenu() {
		System.out.println("Creating a Flashcard");
		System.out.println("Entre Flashcard question: ");
		String question = scan.nextLine();
		System.out.println("Enger FlashCard answer: ");
=======
=======
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
import java.util.Scanner;

import com.revature.pojo.FlashCard;

public class Menus {

	public static void welcome() {
<<<<<<< HEAD
		System.out.println("**********************");
		System.out.println("*Welcome to FlashCards*");
		System.out.println("**********************");
	}
	
	
	public static FlashCard createFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Creating a Flashcard---");
		System.out.println("Enter FlashCard question: ");
		String question = scan.nextLine();
		System.out.println("Enter FlashCard answer: ");
>>>>>>> fa66388667395c761e59539daaea36af9d01238b
=======
		System.out.println("---------------------------------");
		System.out.println("------Welcome to FlashCards------");
		System.out.println("---------------------------------");
	}
	
	
	public static FlashCard createFlahsCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("------Creating a Flashcard-------");
		System.out.println("---------------------------------");
		System.out.println("Enter FlashCard question: ");
		String question = scan.nextLine();
		System.out.println("Enter FlashCard answer: ");
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
		String answer = scan.nextLine();
		
		FlashCard fc = new FlashCard(0, question, answer);
		
		return fc;
<<<<<<< HEAD
<<<<<<< HEAD
=======
		
>>>>>>> fa66388667395c761e59539daaea36af9d01238b
=======
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	}
}
