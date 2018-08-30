package com.revature.model;

public class Manager {

	private String name;
	private int age;
	private String role;
	
	public Manager() {}

	public Manager(String name, int age, String role) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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
		return "Manager [name=" + name + ", age=" + age + ", role=" + role + "]";
	};
	
}
