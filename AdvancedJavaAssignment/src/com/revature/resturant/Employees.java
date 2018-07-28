package com.revature.resturant;

import com.revature.exception.LessThanException;

public abstract class Employees {
	
	public String empName;
	private int yearsOfWorkExp;
	private int payRatePerHour;
	
	//NO-ARGS constructor
	public Employees() {	}
	
	public abstract void hiring();

	//constructor
	public Employees(String empName, int yearsOfWorkExp, int payRatePerHour) {
		super();
		this.empName = empName;
		this.yearsOfWorkExp = yearsOfWorkExp;
		this.payRatePerHour = payRatePerHour;
	}

	//my getters and setters
	public int getYearsOfWorkExp() {
		return yearsOfWorkExp;
	}

	//Unchecked exception where if the experience is less than recommended then we cannot proceed
	public void setYearsOfWorkExp(int yearsOfWorkExp) {
		if(yearsOfWorkExp < 2) {
			System.out.println("not enough experience, we cannot hire");
			throw new LessThanException();
		} else {
			this.yearsOfWorkExp = yearsOfWorkExp;
		}
	}

	public int getPayRatePerHour() {
		return payRatePerHour;
	}

	public void setPayRatePerHour(int payRatePerHour) {
		this.payRatePerHour = payRatePerHour;
	}

	@Override
	public String toString() {
		return "Employees [empName=" + empName + ", yearsOfWorkExp=" + yearsOfWorkExp + ", payRatePerHour=" + payRatePerHour + "]";
	}

	
	
	
	
	
	
	
	
	
	
}
