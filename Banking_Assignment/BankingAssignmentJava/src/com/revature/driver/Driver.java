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
							while(userSelection1 != 5 && me.getUserID() != 138)	{
							PresentationLogic.AfterLoginScreen();
								userSelection1 = scanny.nextInt();
							switch (userSelection1) {
									case 1:
										System.out.println("\n\tYou have " + x.getUserBalance(me) + "$ in your account");	
									break;
									case 2:
										int depositAmount = PresentationLogic.depositScreen();
										int success = x.depositMoney(me,depositAmount);
										if (success > 0) {
											PresentationLogic.successDepositMessage();
											}
											else {
											PresentationLogic.failDepositMessage();
											}
									break;
									case 3:
										int withdrawalAmount = PresentationLogic.withdrawScreen();
										int successOrFail = x.withdrawMoney(me,withdrawalAmount);
										if (successOrFail == 1) {
										PresentationLogic.successWithdrawMessage();
										}
										else {
										PresentationLogic.failWithdrawMessage();
										}
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
					if(newCustomer.getUserID() == 138) {
						break;
					}
					UserDao persistCustomer = new UserDaoImplementation();
					int numRowsUpdated = persistCustomer.createUser(newCustomer);
					if(numRowsUpdated < 1) {
						PresentationLogic.errorMessage();;
					}
					else PresentationLogic.successMessage();
				break;
			case 3:
					User me2 = PresentationLogic.loginScreen();
					
					
				System.exit(1);
				break;
			case 4:
				System.out.println("\nExiting...\nThank you for using Humphrey Central Bank!");
				System.exit(1);
				break;
			default: 
					System.out.print("Enter a number 1 - 3");
			
			}
		}
	}

}
