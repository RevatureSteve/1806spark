package com.revature.presentation;

import java.util.Scanner;

import com.revature.beans.Student;

public class PresentationUtil {
	
	/*
	 * Useful class that will hold views or presentation logic
	 */
	/*
	 * welcomeMenu is static which means we will access it in another class 
	 * by ClassName.methodName
	 * 	PresentationUtil.welcomeMenu()
	 */
	
	
	public static void welcomeMenu() {
		System.out.println("Welcome please select from the list below");
		System.out.println("enter 1 to create a new student");
		System.out.println("enter 2 for reading the current student");
		System.out.println("enter 3 to Exit");
		
	}
	
	public static Student creatingNewStudent() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("----------NEW STUDENT-----------");
		System.out.println("Enter Student Name: ");
		String studName = scan.nextLine();
		System.out.println("Enter GPA: ");
		double studGpa = scan.nextDouble();
		System.out.println("Enter SSN: ");
		int studSsn = scan.nextInt();
		
		Student stud = new Student(55, studName, studGpa, studSsn);
		scan.close();
		return stud;
		
	}
	
	public static void presentStudent(Student stud) {
		System.out.println("---------Current Student-----------");
		System.out.println(stud);
	}
	public static void errorView(String message) {
		System.out.println("Sorry something went wrong...");
		System.out.println("message");
	}
}
