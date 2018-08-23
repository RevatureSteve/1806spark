package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *  JPA - Java Persistence API
 */
@Entity
@Table(name="FC_USER")
public class FcUser {

	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	
	
	public FcUser() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "FcUser [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
