package com.registrar;

import com.registrar.presentation.Menus;

public class Tuition_Driver {
	
	public static boolean session = true;
	
	public static void main(String[] args) {
		
		Menus.welcome();
		
		while (session) {
			Menus.options();
			Menus.input();
		}
		
	}

}
