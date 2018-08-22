package com.revature.service;

import java.util.Scanner;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class PresentationLogic {
	
	public static void managerAfterLoginScreenn() {
		
		System.out.println("\n1) register a new employee");
		System.out.println("2) view all reimbursement requests");
	}
	
	
	public static User login() {
		User dbUser = null;
		Scanner scanny = new Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\tLogin");
		System.out.print("Enter your email: ");
		String email = scanny.nextLine();
		System.out.print("\nEnter your password: ");
		String password = scanny.nextLine();
		dbUser = (new UserDaoImpl()).getUserByEmail(email);
		
		while(dbUser == null) {
			System.out.print("\nIncorrect username or password...Please try again\n\n");
			System.out.print("Enter your email: ");
			email = scanny.nextLine();
			System.out.print("\nEnter your password: ");
			password = scanny.nextLine();
			dbUser = (new UserDaoImpl()).getUserByEmail(email);
		}
		while(!(dbUser.getPassword().equals(password))){
			System.out.print("\nIncorrect username or password...Please try again\n\n");
			System.out.print("Enter your email: ");
			email = scanny.nextLine();
			dbUser = (new UserDaoImpl()).getUserByEmail(email);
			System.out.print("\nEnter your password: ");
			password = scanny.nextLine();
			while(dbUser == null) {
				System.out.print("\nIncorrect username or password...Please try again\n\n");
				System.out.print("Enter your email: ");
				email = scanny.nextLine();
				System.out.print("\nEnter your password: ");
				password = scanny.nextLine();
				dbUser = (new UserDaoImpl()).getUserByEmail(email);
			}
			
		}	
		System.out.print("\nWelcome, " + dbUser.getFname() + " " + dbUser.getLname() + "\n");
		return dbUser;
	}
	
	
	
	public static int registerUserScreen() {
		String position = "";
		int positionId = 0;
		Scanner scanny = new Scanner(System.in);
		System.out.println("\n\t\t\t\t\t\t\t\tRegister New Employee");
		System.out.print("Enter employee's email: ");
		String email = scanny.nextLine();
		System.out.print("\nEnter employee's first name: ");
		String fname = scanny.nextLine();
		System.out.print("\nEnter employee's last name: ");
		String lname = scanny.nextLine();
		while((!(position.equalsIgnoreCase("y"))) && (!(position.equalsIgnoreCase("yes"))) && (!(position.equalsIgnoreCase("manager"))) 
				&& (!(position.equalsIgnoreCase("n"))) && (!(position.equalsIgnoreCase("no"))) && (!(position.equalsIgnoreCase("employee"))))
		{
			System.out.print("\nIs the employee a manager (y/n) ");
		position = scanny.nextLine();
		if(position.equalsIgnoreCase("y") || position.equalsIgnoreCase("yes") || position.equalsIgnoreCase("manager")) {
			positionId = 1;
		}
		else if(position.equalsIgnoreCase("n") || position.equalsIgnoreCase("no") || position.equalsIgnoreCase("employee")) {
			positionId = 0;
		}
		else {
			System.out.println("\n\t\t\t\t\t\t\t\tInvalid character");
		}
		}
		User employee = new User(0,email,ServiceMethods.randomPassword(),fname,lname,positionId);
		int rowsAffected = (new UserDaoImpl().registerEmployee(employee));
		return rowsAffected;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
