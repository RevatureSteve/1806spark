package com.bank;

import com.bank.dao.BankDao;
import com.bank.presentation.Menus;

public class Driver {

	public static void main(String[] args) {
		
		//Welcome Menu.
		Menus menu = new Menus();
		menu.welcome();
		BankDao bdao = new BankDao();
		
		//Gets all users in DB.
		//bdao.getAllUsers();
	
		//Login for user.
		bdao.getUserLogin("hlaw", "hlaw456");
		
		//Main Menu
		menu.mainMenu();

		
		
		
		
		
	}

}
