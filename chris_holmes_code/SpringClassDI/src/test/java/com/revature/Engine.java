package com.revature;

public class Engine {

	private String sound;
	private String power;
	public Engine() {
		super();
	}
	public Engine(String sound, String power) {
		super();
		this.sound = sound;
		this.power = power;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Engine [sound=" + sound + ", power=" + power + "]";
	}
	
	
	
}
