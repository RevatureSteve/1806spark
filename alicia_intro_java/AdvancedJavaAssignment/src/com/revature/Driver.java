package com.revature;

import java.io.IOException;
import java.util.Scanner;

import com.revature.abstracts.Attractions;
import com.revature.dao.AttractionDao;
import com.revature.exceptions.EmptyStringException;
import com.revature.interfaces.Visitable;
import com.revature.pojo.Lighthouse;
import com.revature.pojo.NationalParks;
import com.revature.presentation.PresentationUtil;
import com.revature.threads.LighthousePersistThread;
import com.revature.threads.NationalParkPersistThread;

public class Driver {

	public static void main(String[] args) {
		
//		Lighthouse currituck = new Lighthouse("Currituck", "Corolla, NC", 162, true);
//		NationalParks acadia = new NationalParks("Acadia", "Maine", "hiking", 46856);
//		currituck.findAttraction();
//		Visitable.visiting(currituck.getName());
//		currituck.visited();
//		acadia.whatToDo();
		
		
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			PresentationUtil.welcomeMenu();
			int userInput = scan.nextInt();
			
			switch (userInput) {
			case 1:
				promptNewLighthouseAndPersist();
				break;
			case 2:
				promptNewNationalParkAndPersist();
				break;
			case 3:
				getAttractionAndDisplay();
				break;
			case 4:
				System.out.println("Exiting...");
				System.exit(1);
			}
		}

	}
	
	public static Lighthouse light = null;
	
	public static void promptNewLighthouseAndPersist() {
		
		try {
			light = PresentationUtil.creatingLighthouse();
		} catch (EmptyStringException e) {
			e.printStackTrace();
		}

		Thread t1 = new LighthousePersistThread();
		t1.start();
	}
	
	public static NationalParks park= null;
	
	public static void promptNewNationalParkAndPersist() {

		try {
			park = PresentationUtil.creatingNationalPark();
		} catch (EmptyStringException e) {
			e.printStackTrace();
		}
		
		Thread t2 = new NationalParkPersistThread();
		t2.start();
		
	}
	
	
	public static void getAttractionAndDisplay() {
		Attractions att = AttractionDao.deserializeableAttraction();
		
		PresentationUtil.presentAttraction(att);
		
		System.out.println(AttractionDao.readAttraction());
	}

}
