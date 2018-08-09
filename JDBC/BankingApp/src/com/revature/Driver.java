package com.revature;

import com.revature.dao.BankingAppDao;
import com.revature.dao.BankingAppDaoImpl;
import com.revature.pojo.User;
import com.revature.presentation.Menus;

public class Driver {
	
		public static void main(String[] args) {
			
			Menus.welcome();
			Menus.createBankingAppMenu();
			
//			System.out.println("test");
//			BankingAppDao baDao = new BankingAppDaoImpl(); 
//		
//			Menus.welcome();
//			User userInput = Menus.createBankingAppMenu();
//			System.out.println(userInput);
//			
//			 baDao.createBankingAppMenu(userInput);
			
		}
	
	}


