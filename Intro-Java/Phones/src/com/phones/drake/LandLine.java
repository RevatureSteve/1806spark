package com.phones.drake;

public class LandLine extends Phone {
	
	public LandLine() {
		super();
	}
	
	public LandLine(String bodyColor) {
		super(bodyColor);
	}
	
	public void connect() {
		System.out.println("ring, ring");
		this.isConnected = true;
	}
	
	public void disconnect() {
		System.out.println("you put the phone back in its cradle");
		this.isConnected = false;
	}
	
	public void listProperties() {
		System.out.println(this.getBodyColor());
		System.out.println("You have " + this.getMessages() + " messages");
	}

}
