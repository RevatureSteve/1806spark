package com.revature.model;

public class Employee {

	
	private String name;
	private String role;
	private int id;
	
	public Employee() {};
	
	public Employee(String name, String role, int id) {
		super();
		this.name = name;
		this.role = role;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + ", id=" + id + "]";
	}
	
	
}
