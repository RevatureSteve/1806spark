package com.revature.model;

import java.util.List;

public class Manager {

	@Override
	public String toString() {
		return "Manager [age=" + age + ", name=" + name + "]";
	}

	int age;
	String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Manager() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

}
