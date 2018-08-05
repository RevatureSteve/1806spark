package com.revature.driver;

import java.util.Scanner;

import com.revature.abstractClasses.UserDao;
import com.revature.concreteClasses.BankAccount;
import com.revature.concreteClasses.User;
import com.revature.dao.UserDaoImplementation;
import com.revature.presentation.PresentationLogic;

public class Driver {
	
	static UserDao x = new UserDaoImplementation();
	static int userSelection1;

	public static void main(String[] args) {	
		Scanner scanny = new Scanner(System.in);
		while(true)	{
			scanny = new Scanner(System.in);
			PresentationLogic.presentScreen();
			int userSelection = scanny.nextInt();
			switch (userSelection) {
			
			case 1:
					User me = PresentationLogic.loginScreen();
							while(userSelection1 != 5)	{
							PresentationLogic.AfterLoginScreen();
								userSelection1 = scanny.nextInt();
							switch (userSelection1) {
									case 1:
										BankAccount money = x.getUserBalance(me);
										System.out.println("\n\tYou have " + money.getBalance() + "$ in your account");	
									break;
									case 2:
										
										
										
										
										
									break;
									case 3:
										
										
										
										
										
									break;	
									case 4:
										
										
										
										
										
									break;	
									case 5:
										
										
										System.out.println("Signing Out...Thank You");
										
										
									break;	
									default: 
										System.out.print("Enter a number 1 - 5");
									break;
							  
							}
						}
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
