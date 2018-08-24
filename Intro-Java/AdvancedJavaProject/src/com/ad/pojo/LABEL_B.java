package com.ad.pojo;

import com.ad.abstracts.Dragon;
import com.ad.abstracts.NoBreathException;

public class LABEL_B extends Dragon implements Fly{
	public String breathType;

	public LABEL_B() {
		super();
	}

	public LABEL_B(String name, int age, String breathType) {
		super(name, age);
		this.breathType=breathType;
	}

	@Override
	public void home() {
		System.out.println("I usualy live on high mountains.");
		
	}

	public String getBreathType() {
		return breathType;
	}

	public void setBreathType(String breathType) throws NoBreathException{
		if (breathType == "") {
			System.out.println("(pst...Hey uh, dev here. Sorry but this type of dragon needs a breath type. Ill set it to fire for now.)");
			this.breathType = "Fire";
			throw new NoBreathException();
		} else {
			this.breathType = breathType;
		}
	}

	@Override
	public void wings() {
		System.out.println("I have 2 wings");
	}
}
