package com.revature;

import java.io.IOException;
import java.util.Scanner;

import com.revature.abstracts.Drinks;
import com.revature.dao.DrinksDao;
import com.revature.exceptions.EmptyStringException;
import com.revature.interfaces.Drinkable;
import com.revature.pojo.Bottle;
import com.revature.pojo.Can;
import com.revature.presentation.PresentationUtil;
import com.revature.threads.SodaPersistThread;
import com.revature.threads.JuicePersistThread;

public class Driver {

	public static void main(String[] args) {
		
		Bottle juice = new Bottle("Naked Juice", 24, 5);
		Can soda = new Can("Coke", 12, 2);
		juice.printDrinkInfo();
		Drinkable.whatYouDrank(juice.getBrandName());
		System.out.println();
		juice.drank();
		soda.printDrinkInfo();
		Drinkable.whatYouDrank(soda.getBrandName());
		soda.drank();
		
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			PresentationUtil.welcomeMenu();
			int userInput = scan.nextInt();
			switch (userInput) {
			case 1:
				promptSodaAndPersist();
				break;
			case 2:
				promptJuiceAndPersist();
				break;
			case 3:
				getDrinksAndDisplay();
				break;
			case 4:
				System.out.println("Thank you for making some drinks!  Have a great day! Bye bye!");
				System.exit(1);
			}
		}

	}
	
	public static Can soda = null;
	
	
	public static void promptSodaAndPersist() {
		
		try {
			soda = PresentationUtil.makingSoda();
		} catch (EmptyStringException e) {
			e.printStackTrace();
		}

		Thread t1 = new SodaPersistThread();
		t1.start();
		
	}
	
	public static Bottle juice= null;
	
	
	public static void promptJuiceAndPersist() {
		
		try {
			juice = PresentationUtil.makingNewJuice();
		} catch (EmptyStringException e) {
			e.printStackTrace();
	}
		
		Thread t2 = new JuicePersistThread();
		t2.start();
		
	}
	
	
	public static void getDrinksAndDisplay() {
		Drinks drk = DrinksDao.deserializeableDrinks();
		
		PresentationUtil.presentDrinks(drk);
		
		System.out.println(DrinksDao.readDrinks());
	}

}
