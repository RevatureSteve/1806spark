package com.revature.model;

<<<<<<< HEAD
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
=======
public class Manager {
	
	private int id;
	private String name;
	
	public Manager() {
	}

	public Manager(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
>>>>>>> 0859023c77c3912cdd1b0fc58087b1984fdb1be1
	}

	public String getName() {
		return name;
	}

<<<<<<< HEAD
	public Manager() {
		super();
	}

=======
>>>>>>> 0859023c77c3912cdd1b0fc58087b1984fdb1be1
	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
	public Manager(int age, String name) {
		super();
		this.age = age;
		this.name = name;
=======
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + "]";
>>>>>>> 0859023c77c3912cdd1b0fc58087b1984fdb1be1
	}

}
