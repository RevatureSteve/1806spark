package com.revature.model;

public class Manager {
	
	private String name;
	private int parkingSpace;
	private int age;
	
	private Employee employee;
	
	public Manager() {
		super();
	}
	
	
	
	public Manager(String name, int parkingSpace, int age, Employee employee) {
		super();
		this.name = name;
		this.parkingSpace = parkingSpace;
		this.age = age;
		this.employee = employee;
	}
	public Manager(String name, int parkingSpace, int age) {
		super();
		this.name = name;
		this.parkingSpace = parkingSpace;
		this.age = age;
		
	}



	@Override
	public String toString() {
		return "Manager [name=" + name + ", parkingSpace=" + parkingSpace + ", age=" + age + ", employee=" + employee
				+ "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getParkingSpace() {
		return parkingSpace;
	}



	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
}
