package com.revature.resturant;

public class BackOfHouse extends Employees{
	
	public String backJobTitle;
	public String empName;
	
	
	//create a constructor to get name to display on sysout
	public BackOfHouse() {
		empName = backJobTitle;
	}
	
	//trying to get this to print to the main but always comes up null
	public void Cooking() {
		System.out.println(empName + " will now prepare your dish");
	}
	
	
	

	@Override
	public String toString() {
		return "BackOfHouse [backJobTitle = " + backJobTitle + ", empName = " + empName + ", getYearsOfWorkExp() = "
				+ getYearsOfWorkExp() + ", getPayRatePerHour() = " + getPayRatePerHour() + "]";
	}




	@Override
	public void hiring() {
		System.out.println("now hired");
	}



	
	

}
