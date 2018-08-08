package com.bank;

import com.bank.dao.BankDaoImpl;
import com.bank.presentation.Menus;

public class Driver {

	public static void main(String[] args) {
		
		//Welcome Menu.
		Menus menu = new Menus();
		menu.welcome();
		BankDaoImpl bdao = new BankDaoImpl();

		//Login for user.
		bdao.getUserLogin();
		
		//Main Menu
		menu.mainMenu();

		
		
		
		
		
	}

}
