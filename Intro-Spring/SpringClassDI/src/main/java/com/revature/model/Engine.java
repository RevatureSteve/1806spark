package com.revature.model;

import org.springframework.stereotype.Component;

/**
 * @author skels
 *
 */
@Component(value="powerfulEngine")
public class Engine {

	private String sound;
	private int power;
	
	public Engine() {
	}

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
		return "Engine [sound=" + sound + ", power=" + power + "]";
	}

	
}
