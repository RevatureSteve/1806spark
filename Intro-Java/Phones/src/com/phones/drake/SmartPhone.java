package com.phones.drake;

public class SmartPhone extends Phone {
	
	public SmartPhone() {
		super();
	}
	
	// interesting chain
	public SmartPhone(String bodyColor) {
		super(bodyColor);
	}
	
	public static void togglePlug(Phone phone) {
		if (isUnplugged == true) {
			isUnplugged = false;
		} else isUnplugged = true;
	}
	
	public void connect() {
		System.out.println("SmartPhone is connecting");
		this.isConnected = true;
	}
	
	public void disconnect() {
		System.out.println("Disconnecting call service");
		this.isConnected = false;
	}
	
	public void listProperties() {
		System.out.println(this.getBodyColor());
		System.out.println("You have " + this.getMessages() + " messages");
	}

}
