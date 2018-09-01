package com.revature.model;

import java.util.Arrays;

public class Manager {
	
	private String name;
	private int age;
	private Employee[] team;
	
	public Manager() {}
	
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
	
	public Employee[] getTeam() {
		return team;
	}
	
	public void setTeam(Employee[] team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ", age=" + age + ", team=" + Arrays.toString(team) + "]";
	}

}
