package com.revature.presentation;

import java.util.Scanner;

import com.revature.beans.Student;

public class PresentationUtil {
	
	/*
	 * 
	 * useful class that will hold views or presentation logic 
	 * 
	 * 
	 * 
	 */
	
	public static void Welcome() {
		// TODO Auto-generated method stub
		System.out.println("Welcome please select from the list below" );
		System.out.println("enter 1 for creating  anew student");
		System.out.println("enter 2 for reading current student");
		System.out.println("enter 3 to exit");
	}
	
	public static Student creatingNewStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------New Student_-_--------___-_");
		System.out.println("Enter student name");
		String studName = scan.nextLine();
		System.out.println("Enter gpa");
		double studGpa = scan.nextDouble();
		System.out.println("Enter SSN");
		int studSsn = scan.nextInt();
		scan.close();
		Student stud = new Student(55,studName,studGpa,studSsn);
		return stud;
		
	}
	
	public static void presentstudent(Student stud) {
		System.out.println("------current student-_-_-_-_-_");
		System.out.println(stud);
	}

}
