package com.ad.pojo;

import com.ad.abstracts.Dragon;

public class LABEL_C extends Dragon implements Fly{
	public String ability;

	public LABEL_C() {
		super();
	}

	public LABEL_C(String name, int age, String ability) {
		super(name, age);
		this.ability=ability;
	}

	@Override
	public void home() {
		System.out.println("I live in numerous hidden environments.");
		
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	@Override
	public void wings() {
		System.out.println("I have 4 wings");
		
	}
}
