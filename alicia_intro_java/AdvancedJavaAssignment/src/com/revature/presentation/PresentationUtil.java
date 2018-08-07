package com.revature.presentation;

import java.util.Scanner;

import com.revature.abstracts.Attractions;
import com.revature.exceptions.EmptyStringException;
import com.revature.pojo.Lighthouse;
import com.revature.pojo.NationalParks;

public class PresentationUtil {
	
	public static void welcomeMenu() {
		System.out.println("Please select from the options below:");
		System.out.println("Enter 1 to create a new lighthouse");
		System.out.println("Enter 2 to create a new National Park");
		System.out.println("Enter 3 to read your attractions");
		System.out.println("Enter 4 to exit");
	}
	
	public static Lighthouse creatingLighthouse() throws EmptyStringException {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----New Lighthouse-----");
		System.out.println("Enter lighthouse name:");
		String lightName = scan.nextLine();
		System.out.println("Enter location:");
		String lightLocation = scan.nextLine();
		System.out.println("Enter height:");
		int lightHeight = scan.nextInt();
		
		Lighthouse light = new Lighthouse();
		light.setName(lightName);
		light.setLocation(lightLocation);
		light.setHeight(lightHeight);
		
		return light;
		
	}
	
	
	public static NationalParks creatingNationalPark() throws EmptyStringException {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----New National Park-----");
		System.out.println("Enter national park name:");
		String parkName = scan.nextLine();
		System.out.println("Enter location:");
		String parkLocation = scan.nextLine();
		System.out.println("Enter activities:");
		String parkActivity = scan.nextLine();
		System.out.println("Enter area:");
		int parkArea = scan.nextInt();
		
		NationalParks park = new NationalParks();
		park.setName(parkName);
		park.setLocation(parkLocation);
		park.setArea(parkArea);
		park.setActivities(parkActivity);
		
		return park;
		
	}
	
	
	public static void presentAttraction(Attractions att) {
		System.out.println("-----Current Attraction-----");
		System.out.println(att);
	}
	
}
