package com.revature;

public class Employee {

	private String name;
	private String age;
	private String role;
	
	
	public Employee() {
		super();
	}


	public Employee(String name, String age, String role) {
		super();
		this.name = name;
		this.age = age;
		this.role = role;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", role=" + role + "]";
	}
	
	
	
	
}
