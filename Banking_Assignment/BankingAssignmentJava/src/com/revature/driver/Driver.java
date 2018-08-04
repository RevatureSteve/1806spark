package com.revature.driver;

import java.util.Scanner;

import com.revature.abstractClasses.UserDao;
import com.revature.concreteClasses.User;
import com.revature.dao.UserDaoImplementation;
import com.revature.presentation.PresentationLogic;

public class Driver {

	public static void main(String[] args) {	
		Scanner scanny = new Scanner(System.in);
		while(true)	{
			scanny = new Scanner(System.in);
			PresentationLogic.presentScreen();
			int userSelection = scanny.nextInt();
			switch (userSelection) {
			
			case 1:
					PresentationLogic.loginScreen();
					PresentationLogic.AfterLoginScreen();
				break;
			case 2:
					User newCustomer = PresentationLogic.creatingNewUser();
					UserDao persistCustomer = new UserDaoImplementation();
					int numRowsUpdated = persistCustomer.createUser(newCustomer);
					if(numRowsUpdated < 1) {
						PresentationLogic.errorMessage();;
					}
					else PresentationLogic.successMessage();
				break;
			case 3:
					System.out.println("\nExiting...\nThank you for using Humphrey Central Bank!");
				System.exit(1);
				break;
			default: 
					System.out.print("Enter a number 1 - 3");
			
			}
		}
	}

}
