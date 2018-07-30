package com.advanced.abstracts;

import java.io.Serializable;

public abstract class Dragon implements Serializable{
	
	private static final long serialVersionUID = 11037;
	
	public String name;
	public int age;

	public abstract void home();

	public Dragon() {
		super();
	}

	public Dragon(String name, int age) {
		this.name = name;
		this.age = age;
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

	public void setAge(int age) throws NoAgeException{
		if (age < 0) {
			System.out.println("(pst...hey uh, dev here. Sorry but a negative age is, well impossible. Judging by past records I'd say this one is about 220)");
			this.age = 220;
			throw new NoAgeException();
		} else {
			this.age = age;
		}
	}

}
