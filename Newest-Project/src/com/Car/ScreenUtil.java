package com.Car;

import java.util.Scanner;

import com.Car.exception.NegativeArgException;



public class ScreenUtil {

	public static void welcomeScreen() {
		System.out.println("Would you like to build a car? \n Please "
				+ "select from the following options:");
		System.out.println("Enter 1 to create a new Sports car!");
		System.out.println("Enter 2 to create a new Sedan!");
		System.out.println("Enter 3 to see your Sports car!");
		System.out.println("Enter 4 to see your Sedan!");
		System.out.println("Enter 5 to exit...");
	}
	public static lilCar buildingCar() {
		int seatCount = 0;
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("---New Sports Car---");
		System.out.println("How many cylinders does your car have?");
		int cylNum = scan.nextInt();
		System.out.println("How much horse power?");
		int hp = scan.nextInt();
		System.out.println("How many seats?");
		seatCount = scan.nextInt();
		if(seatCount <= 0) {
			throw new NegativeArgException("You can't do that! Car must have atleast 1 door...");
		}
		System.out.println("What is the model?");
		String model = scan2.nextLine();
		System.out.println("What is the MPG?");
		int mpg = scan2.nextInt();
		
		lilCar car = new lilCar(hp, cylNum, seatCount, model, mpg);
		return (lilCar) car;
	}
	public static Speakers buildingSedan() {
		int seatCount = 0;
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("---New Sedan---");
		System.out.println("How many cylinders does your car have?");
		int cylNum = scan.nextInt();
		System.out.println("How many Advanced features?");
		int hp = scan.nextInt();
		System.out.println("How many seats?");
		seatCount = scan.nextInt();
		if(seatCount <= 0) {
			throw new NegativeArgException("You can't do that! Car must have atleast 1 door...");
		}
		System.out.println("What is the model?");
		String model = scan2.nextLine();
		System.out.println("How many speakers do you have?");
		int speak = scan2.nextInt();
		
		
		Speakers car = new Speakers(hp, cylNum, seatCount, model, speak);
		return (Speakers) car;
		
	}
	public static void currentCar(lilCar car) {
		System.out.println("---Current Car---\n" + car);
	}
	public static String currentCar(Speakers car) {
		return "---Current Car---\n" + car;
	}
	public static void carError(String msg) {
		System.out.println(msg);
	}
}
