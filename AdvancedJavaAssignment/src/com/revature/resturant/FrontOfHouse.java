package com.revature.resturant;

import com.revature.exception.NoEmptyString;

public class FrontOfHouse extends Employees {
	
	private String frontJobTitle;
	
	
	
	public void Serving() {
		System.out.println("The hostess will now seat you");
	}
	
	public void Waiting( ) {
		System.out.println("Your waiter will now take your order");
	}
	
	public String getFrontJobTitle() {
		return frontJobTitle;
	}

	//Checked exception, had to be a created exception for empty strings
	//incomplete atm
	public void setFrontJobTitle(String frontJobTitle) {
		if(frontJobTitle == null) {
			System.out.println("you must fill job title");
			throw new NoEmptyString();
		} else {
		this.frontJobTitle = frontJobTitle;
		}
	}

	@Override
	public String toString() {
		return "FrontOfHouse [frontJobTitle = " + frontJobTitle + ", empName = " + empName 
				+ ", getYearsOfWorkExp() = " + getYearsOfWorkExp() + ", getPayRatePerHour() = " + getPayRatePerHour() + "]";
	}

	@Override
	public void hiring() {
		System.out.println("now hired");
	}
	

}
