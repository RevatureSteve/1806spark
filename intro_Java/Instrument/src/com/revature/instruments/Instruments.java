package com.revature.instruments;

public class Instruments {
//State	/variables
	protected static String name;
	private String type;
	private boolean soundsGood;
	private int weight;
	private int size;
	
//No ARGS Constructor
	public Instruments() {
		}

	public Instruments(String name, String type, boolean soundsGood, int size) {
		super();
		this.name = name;
		this.type = type;
		this.soundsGood = soundsGood;
		this.size = size;
	}
//overloaded constructor- added int cost
	public Instruments(String name, String type, boolean soundsGood, int size, int cost) {
		super();
		this.name = name;
		this.type = type;
		this.soundsGood = soundsGood;
		this.size = size;
	}
	
	
	
//Behaviors
	


}
