package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;
import com.revature.service.PresentationLogic;

public class Driver {
	
	static UserDao x = new UserDaoImpl();
	static Scanner scanny = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		User me =PresentationLogic.login();
		
		
		
		if(x.getUserPositionName(me.getPositionId()).equalsIgnoreCase("Manager")) {
			PresentationLogic.managerAfterLoginScreenn();
			String userChoice=scanny.nextLine();
			
			switch (userChoice) {
			
					case "1":
						int succes = PresentationLogic.registerUserScreen();
						System.out.println("Successfully registered");
						
					   break;
					case "2":
					
						
						
					break;
					case "3":
				
						
						
					break;
					case "4":
			
						
						
					break;
					default:
						
						
					break;
			
		}
		}

		else {
			System.out.println("Not Manager");
		}
		
		
		
		
		
		
		
		
		
	}

}
