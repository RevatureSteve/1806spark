package com.ad.pojo;

public class MountainDrake extends LABEL_B implements Fly{

	public MountainDrake() {
		super();
	}

	public MountainDrake(String name, int age, String breathType) {
		super(name, age, breathType);
	}

	@Override
	public void home() {
		System.out.println("Said to mostly live in the mountains");
	}
	
	@Override
	public void wings() {
		System.out.println("Seen flying with 2 wings");
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nCurrent known age: " + age + " years." + "\nCan Breath: " + breathType;
	}
}
