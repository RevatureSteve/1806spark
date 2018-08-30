package com.revature.bean;

public class Engine {
	private int power;
	private String sound;

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Engine [power=" + power + ", sound=" + sound + "]";
	}

}
