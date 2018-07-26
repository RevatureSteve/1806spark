package com.phones.drake;

// an abstract class can be a template for a POJO, but is not a POJO itself
public abstract class Phone {
	
	private int[] numbersDialed;
	private String bodyColor;
	public boolean isConnected;
	public static boolean isUnplugged;
	private int messages;
	
	public Phone() {}
	
	public Phone(String bodyColor) {
		this.bodyColor = bodyColor;
	}
	
	public abstract void connect();
	
	public abstract void disconnect();
	
	public abstract void listProperties();
	
	// make this dynamic with a phone instance's messages/unread messages
	public void callVoicemail() {
		// use template literal
		System.out.println("You have x new messages");
	}

	public int[] getNumbersDialed() {
		return numbersDialed;
	}

	public void setNumbersDialed(int[] numbersDialed) {
		this.numbersDialed = numbersDialed;
	}

	public String getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	public int getMessages() {
		return messages;
	}

	public void setMessages(int messages) {
		this.messages = messages;
	}
	

}
