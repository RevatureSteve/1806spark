package com.advanced.presentation;

import com.advanced.drake.Pizza;

public class UserMenuDisplay {
	
	public static void welcome() {
		System.out.println("Welcome to Pizza Palace");
		System.out.println("Enter:");
		System.out.println("\t" + "1 to start new order");
		System.out.println("\t" + "2 to view existing order");
		System.out.println("\t" + "3 to complete order");
	}
	
	public static void choosePizza() {
		System.out.println("For:");
		System.out.println("\t" + "Thick crust: enter 1");
		System.out.println("\t" + "Chicago style: enter 2");
	}
	
	public static void addToppings() {
		System.out.println("How many toppings?");
	}
	
	public static void currentOrder(Pizza pizza) {
		System.out.println("-----Current Order----");
		System.out.println(pizza);
	}

}