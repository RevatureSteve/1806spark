package com.revature.resturant;

public class BackOfHouse extends Employees{
	
	public String backJobTitle;
	
	public void Cooking() {
		System.out.println("The Cook will now prepare your dish");
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
