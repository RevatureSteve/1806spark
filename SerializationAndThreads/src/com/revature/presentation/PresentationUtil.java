package com.revature.presentation;

import java.util.Scanner;

import com.revature.beans.student;

public class PresentationUtil {
	
	/*
	 * useful class that will hold views or presentation logic
	 */
	
	//wecomeMenu is static which means we will access it in another class by className.methodName PresentationUtil.welcomeMenu()
	
	public static void welcomeMenu() {
		System.out.println("Welcome! Please select from the list below \n "
				+ "Enter 1 for a new Student \n "
				+ "Enter 2 for reading the current student");
		System.out.println("Enter 3 to exit");
	}
	public static student creatingNewStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----New Student-----");
		System.out.println("Enter Student name:");
		String studName = scan.nextLine();
		System.out.println("Enter GPA: ");
		double studGpa = scan.nextDouble();
		System.out.println("Enter ssn:  ");
		int studSsn = scan.nextInt();
		
		student stud = new student(22, studName, studGpa, studSsn);
		return stud;
	}
	public static void presentStudent(student stud) {
		System.out.println("------Current Student------\n" + stud );
	}
	public static void errorView(String message) {
		System.out.println("Sorry! Somthing went wrong.....\n" + message);
	}

}
