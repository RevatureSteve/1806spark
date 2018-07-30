package com.revature.resturant;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("List of employees");
		
		//BOH Employees
		BackOfHouse danny = new BackOfHouse();
		danny.backJobTitle = "Head Chef";
		danny.empName = "Daniel S";
		danny.setPayRatePerHour(12);
		danny.setYearsOfWorkExp(5);
		
		//FOH Employees
		FrontOfHouse sherry = new FrontOfHouse();
//		sherry.setFrontJobTitle("Hostess");
		sherry.empName = "Sherry H";
		sherry.setPayRatePerHour(9);
		sherry.setYearsOfWorkExp(6);
		
		System.out.println(danny);
		System.out.println(sherry);
		
		
		BackOfHouse BOHObject = new BackOfHouse();
		BOHObject.Cooking();
		
	
		}
	}
