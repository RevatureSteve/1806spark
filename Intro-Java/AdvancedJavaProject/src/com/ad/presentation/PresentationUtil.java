package com.ad.presentation;

import java.util.Scanner;
import com.ad.pojo.MountainDrake;
import com.ad.pojo.MysticDrake;

import com.ad.abstracts.NoAgeException;

public class PresentationUtil {

	public static void Information(MountainDrake mtn, MysticDrake mys) {
		System.out.println("Ok here is what we know about them.\n");
		System.out.println(mtn.toString());
		mtn.home();
		mtn.wings();
		System.out.println();
		System.out.println(mys.toString());
		mys.home();
		mys.wings();
		System.out.println();
		System.out.println("What do you think?");
		System.out.println("1: Something is wrong with the first dragon");
		System.out.println("2: Something is wrong with the second dragon");
		System.out.println("3: Everything looks good");
	}

	public static MountainDrake UpdateMtn(MountainDrake mtn) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWhat about it?");
		System.out.println("1: name");
		System.out.println("2: age");
		System.out.println("3: Breath type");
		String input = scan.nextLine();
		System.out.println("And what should that be changed to?");
		String newValue = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("test");
			mtn.setName(newValue);
			break;
		case "2":
			try {
				mtn.setAge(Integer.parseInt(newValue));
			} catch (NoAgeException e) {
				e.printStackTrace();
			}
			break;
		case "3":
			mtn.setBreathType(newValue);
			break;
		}
		return mtn;
	}

	public static MysticDrake UpdateMys(MysticDrake mys) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWhat about it?");
		System.out.println("1: name");
		System.out.println("2: age");
		System.out.println("3: ability");
		String input = scan.nextLine();
		System.out.println("And what should that be changed to?");
		String newValue = scan.nextLine();
		switch (input) {
		case "1":
			mys.setName(newValue);
			break;
		case "2":
			try {
				mys.setAge(Integer.parseInt(newValue));
			} catch (NoAgeException e) {
				e.printStackTrace();
			}
			break;
		case "3":
			mys.setAbility(newValue);
			break;
		}
		return mys;
	}
	public static void errorView(String message) {
		System.out.println("Oh. It appears the records a");
		System.out.println(message);
	}
}
