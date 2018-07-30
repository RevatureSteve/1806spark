package com.Car;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Driver {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		SportsCar eclipse = new lilCar();
		Sedan sedan1 = new Sedan();
		
		while(true) {
			ScreenUtil.welcomeScreen();
			int userInput = scan.nextInt();
			switch (userInput) {
			case 1:
				Thread t1 = new SportsCarThread();
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				Thread t2 = new SedanThread();
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				getCarAndDisplay();
				break;
			case 4:
				buffReading();
				break;
			
			case 5:
				System.out.println("Who would'nt want to build a car? Bye!");
				System.exit(1);
				break;

		
			}
		}
	}
	
	public static void getCarAndDisplay() {

		SportsCar car = CarDao.deserializeCar();
		ScreenUtil.currentCar((lilCar) car);
	}
	
	public static void buffReading() {
		BufferedReader reader = null;

		try {
			final String file = "src/com/Car/Sedan.txt";
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
	
}
