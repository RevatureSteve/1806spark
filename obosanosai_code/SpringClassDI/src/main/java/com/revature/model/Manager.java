package com.revature.model;

public class Manager {
	
	private String name;
	private int age;
	private String mgrrole;
	
	public Manager() {
		
	}
	
	public Manager(String name, int age, String mgrrole) {
		super();
		this.name = name;
		this.age = age;
		this.mgrrole = mgrrole;
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
	public String getMgrrole() {
		return mgrrole;
	}
	public void setMgrrole(String mgrrole) {
		this.mgrrole = mgrrole;
	}
	@Override
	public String toString() {
		return "Manager [name=" + name + ", age=" + age + ", mgrrole=" + mgrrole + "]";
	}
	
	

}
