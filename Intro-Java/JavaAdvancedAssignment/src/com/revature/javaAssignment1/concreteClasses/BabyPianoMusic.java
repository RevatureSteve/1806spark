package com.revature.javaAssignment1.concreteClasses;

public class BabyPianoMusic extends PianoMusic {
	
	private String songTitle;
	private int numberOfPlayers;
	
	
	
	public BabyPianoMusic() {
		super();
		System.out.println("Creating a baby piano");
	}
	
	public BabyPianoMusic(String composer, String instrumentUsed, int numberOfPlayers, String songTitle) {
		
		this.composer = composer;
		this.instrumentUsed = instrumentUsed;
		this.numberOfPlayers = numberOfPlayers;	
		this.songTitle = songTitle;
		
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	@Override
	public String toString() {
		return "BabyPianoMusic [numberOfPlayers= " + this.numberOfPlayers + ", songTitle= " + this.songTitle +", instrumentUsed= " + this.instrumentUsed +", composer= " + this.composer + "]";
	}
	
	

}
