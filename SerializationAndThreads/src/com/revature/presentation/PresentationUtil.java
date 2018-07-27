package com.revature.presentation;

import java.util.Scanner;

import javax.xml.ws.handler.MessageContext;

import com.revature.beans.Student;

public class PresentationUtil {
	/*
	 * useful class that will hold views or presentation logic
	 * 
	 * 
	 * WelcomeMenu is static which means we will access it in another class
	 * 		by ClassName.methodName() or if variable ClassName
	 * 			PresentationUtil.welcomeMenu()
	 * 
	 */
	public static void WelcomeMenu() {
		System.out.println("Welcome please select from the list below: ");
		System.out.println("Enter 1 for creating a new student enter");
		System.out.println("Enter 2 for reading a current student enter");
		System.out.println("Enter 3 to exit");
	}
	
	public static Student creatingNewStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("--New Student--");
		System.out.println("enter student name: ");
		String studName = scan.nextLine();
		
		System.out.println("Enter GPA: ");
		double studGpa = scan.nextDouble();
		
		/*System.out.println("Enter ssn: ");
		int studSsn = scan.nextInt();
		*/
		Student stud = new Student(55, studName, studGpa);
		scan.close();
		return stud;
	}
	
	public static void presentStudent(Student stud) {
		System.out.println("--Current Student--");
		System.out.println(stud);
	}
	
	public static void errorView(String message) {
		System.out.println("sorry bro, we messed up. . .");
		System.out.println(message);
		
	}

}
