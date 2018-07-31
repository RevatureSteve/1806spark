package com.revature.presentation;

import java.util.Scanner;

import com.revature.beans.Student;

public class PresentationUtil {

	
	/*
	 *  Useful class that will hold views or presentation logic
	 */
	
	
	//welcomeMenu is a static which means we will access it in another class by ClassName.methodName() 
	// 		or ClassName.variableName
			//PresentationUtil.welcomeMenu();
	
	public static void welcomeMenu() {
		System.out.println("Welcome please select from the list below: ");
		System.out.println("Enter 1 for Creating a new student");
		System.out.println("Enter 2 for reading the current student");
		System.out.println("Enter 3 to exit");
	}
	
	public static Student creatingNewStudent() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------New Student---------");
		System.out.println("Enter Student Name: ");
		String studName= scan.nextLine();
		System.out.println("Enter GPA: ");
		double studGpa = scan.nextDouble();
		System.out.println("Enter social security number");
		int studSsn = scan.nextInt();
		
		Student stud = new Student(55,studName,studGpa,studSsn);
		scan.close(); //Close resource
		return stud;
	}
	
	
	public static void presentStudent(Student stud) {		
		System.out.println("------Current Student---------");
		System.out.println(stud);
	}	
	
	
	public static void errorView(String message) {
		System.out.println("Sorry something went wrong...");
		System.out.println(message);
		
	}
	

	
}
