package com.ad.pojo;

public class MysticDrake extends LABEL_C implements Fly{
	private String breathType;

	public MysticDrake() {
		super();
	}

	public MysticDrake(String name, int age, String ability) {
		super(name, age, ability);
	}

	@Override
	public void home() {
		System.out.println("Said to live in many secluded environments");	
	}
	
	@Override
	public void wings() {
		System.out.println("Seen flying with 4 wings");
		
	}

	public String getBreathType() {
		return breathType;
	}

	public void setBreathType(String breathType) {
		this.breathType = breathType;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nCurrent known age: " + age + " years." + "\nAbility: " + ability;
	}
}
