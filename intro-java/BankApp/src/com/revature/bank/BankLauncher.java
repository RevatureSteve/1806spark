package com.revature.bank;

import com.revature.bank.dao.BankDaoImpl;
import com.revature.bank.exceptions.NegativeInputException;
import com.revature.bank.pojo.Scenes;
import com.revature.bank.pojo.User;
import com.revature.bank.presentation.Flowey;
import com.revature.bank.presentation.Presentation;
import com.revature.bank.service.BankServices;

public class BankLauncher {
	public static void main(String[] args) {
		

		BankDaoImpl bDao = new BankDaoImpl();
		User u = null, db_u = null;
		Scenes sceneCheck = new Scenes();
		double userin = 0;
		int attempts = 0;

		//pre login
		Presentation.intro();
		while(true) {
			if(attempts >=3) {	//catch anyone trying to brute force a login
				Presentation.Hacker();
			}
			u = Presentation.login();
			try {	//try to find a user in the database using the given username
			db_u = bDao.getUser(u.getUsername());
			bDao.getAccountBalance(db_u);
			} catch (NullPointerException e) {  //If no matches were found
				Flowey.uh();
				System.out.println("Sorry but I cant find you in my records. please try again.");
				++attempts;
				continue;
			}
			Flowey.Side();	//login successful
			System.out.println("Ah yes! Welcome back " + db_u.getFirstName() + " " + db_u.getLastName() + ". I certainly didnt forget about you.");
			break;
		}
		
		//post login
		while(true) {
			String input = Presentation.UserMainMenu();  //main menu functions
			switch(input) {
			case "1":	//view balance
				if(Presentation.ViewBalance(db_u.getBalance(), sceneCheck.isViewBalanceScene())) {
					sceneCheck.setViewBalanceScene(true);
				}
				break;
			case "2":	//deposit
				try {
					userin = Double.parseDouble(Presentation.Deposit());
				} catch (NumberFormatException e) { //if any non numbers were given (including nothing)
					Flowey.uh();
					System.out.println("Uhhh, I'm gonna need a number for this.");
					break;
				} catch (NegativeInputException e) { //custom exception for receiving negative numbers
					if(Presentation.Negative2(sceneCheck.isNegativeScene())){
						sceneCheck.setNegativeScene(true);  //if negative number was given, setup final dialogue
					}
					break;
				}
				BankServices.balDeposite(userin, db_u);
				
				break;
			case "3":	//withdraw
				try {
					userin = Double.parseDouble(Presentation.Withdrawl(db_u));
				} catch (NumberFormatException e) {	//if any non numbers were given (including nothing)
					Flowey.uh();
					System.out.println("Uhhh, I'm gonna need a number for this.");
					break;
				} catch (NegativeInputException e) {	//custom exception for receiving negative numbers
					if(Presentation.Negative2(sceneCheck.isNegativeScene())){
						sceneCheck.setNegativeScene(true);	//if negative number was given, setup final dialogue
					}
					break;
				}
				if (userin > db_u.getBalance()) {
					System.out.println("Im sorry but you dont have that much. try again?");
					break;
				}
				BankServices.balWithdral(userin, db_u);
				break;
			case "x":	//exit
				Presentation.exit(sceneCheck.isNegativeScene());
			default:
				System.out.println("Sorry I didnt quite get that.");
			}
		}
	}
}
