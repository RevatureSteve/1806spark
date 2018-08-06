package com.revature;

public class Boardgame implements GameOptions {

	private String name;
	private int numOfPlayers;
	public int playTime;

	public Boardgame() {
		super();
	}

	public Boardgame(String name, int numOfPlayers, int playTime) {
		super();
		this.name = name;
		this.numOfPlayers = numOfPlayers;
		this.playTime = playTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws NoBlanks {

		if (name == null) {
			throw new NoBlanks("Name parameter cannot be empty.");
		}

		this.name = name;

	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {

		if (numOfPlayers < 1) {
			throw new OnePlayerMin("Number of Players must be at least 1.");
		}

		this.numOfPlayers = numOfPlayers;

	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	@Override
	public String toString() {
		return "Boardgame [name=" + name + ", numOfPlayers=" + numOfPlayers + ", playTime=" + playTime + "]";
	}

	@Override
	public void pickGame() {
		System.out.println("I will play " + this.name + " now.");

	}

}
