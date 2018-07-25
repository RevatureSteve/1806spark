package com.revature.abstracts;

public abstract class Workers {
	
	public String type;
	private int salary;
	public boolean uniform;

	public Workers( ) {}

	public Workers(String type, int salary, boolean uniform) {
		super();
		this.type = type;
		this.salary = salary;
		this.uniform = uniform;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
}


