package com.revature.driver;

import java.util.List;
import java.util.Scanner;

import com.revature.abstractClasses.UserDao;
import com.revature.concreteClasses.BankAccount;
import com.revature.concreteClasses.Transaction;
import com.revature.concreteClasses.User;
import com.revature.dao.UserDaoImplementation;
import com.revature.presentation.PresentationLogic;

public class Driver {
	
	static UserDao x = new UserDaoImplementation();
	static int userSelection1;
	static User me = null;

	public static void main(String[] args) {	
		Scanner scanny = new Scanner(System.in);
		while(true)	{
			scanny = new Scanner(System.in);
			PresentationLogic.presentScreen();
			int userSelection = scanny.nextInt();
			switch (userSelection) {
			
			case 1:
				
					 me = PresentationLogic.loginScreen();
							while(userSelection1 != 6 && me.getUserID() != 138)	{
							PresentationLogic.AfterLoginScreen();
								userSelection1 = scanny.nextInt();
							switch (userSelection1) {
									case 1:
										System.out.println("\n\tYou have " + x.getUserBalance(me) + "$ in your account");	
									continue;
									case 2:
										int depositAmount = PresentationLogic.depositScreen();
										int success = x.depositMoney(me,depositAmount);
										if (success > 0) {
											PresentationLogic.successDepositMessage();
											}
											else {
											PresentationLogic.failDepositMessage();
											}
										x.txDeposit(me.getUserID(), depositAmount);
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
										x.txWithdraw(me.getUserID(), withdrawalAmount);
									break;	
									case 4:
										
										List<Transaction> recent =x.viewTransaction(me.getUserID());
										for (Transaction view : recent) {
											if(view.getTx_type_id()==2) {
											 System.out.println("\n\t\t\t\t\t\tTransaction (Withdrawal): " + view.getTx_timestamp() + " -$" + view.getTx_amount());
											}
											else {
												System.out.println("\n\t\t\t\t\t\tTransaction (Deposit): " + view.getTx_timestamp() + " $" + view.getTx_amount());
											}
											}
										
									break;	
									case 5:
										
										
										PresentationLogic.validateUserAgain(me);
										
										
									continue;	
									case 6:
										
										
										System.out.println("\n\tSigning Out...Thank You");
										
										
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
				System.out.println("\nExiting...\nThank you for using Humphrey Central Bank!");
				System.exit(1);
				break;
			default: 
					System.out.print("Enter a number 1 - 3");
			
			}
		}
	}

}
