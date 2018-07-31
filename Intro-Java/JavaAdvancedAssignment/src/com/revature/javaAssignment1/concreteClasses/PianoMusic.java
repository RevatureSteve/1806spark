package com.revature.javaAssignment1.concreteClasses;

import com.revature.javaAssignment1.abstracts.Classical;
import com.revature.javaAssignment1.abstracts.Music;
import com.revature.javaAssignment1.exceptions.NoNegativeException;
import com.revature.javaAssignment1.exceptions.WhatIfNegativeException;

public class PianoMusic extends Classical implements Music{

	
	private int numberOfPlayers;
	private String songTitle;

	public PianoMusic() {
		super();
		System.out.println("Creating new piano music");
	}
	
	
	public PianoMusic(String composer, String instrumentUsed, int numberOfPlayers, String songTitle) {
	
		this.composer = composer;
		this.instrumentUsed = instrumentUsed;
		this.numberOfPlayers = numberOfPlayers;	
		this.songTitle = songTitle;
		
	}

	

	@Override
	public void playInstrument() {

		System.out.println("Start playing music with " + this.instrumentUsed);
		
	}

	
	
	
	/**
	 * The parameter takes an integer for song length (in minutes)
	 */
	@Override
	public void printLengthOfSong(double songLength) {
		if(songLength<0.0) {
			throw new NoNegativeException("Length of Song cannot be negative!");
		}
		
		else {
		System.out.println("The song is " + songLength + " mins long");
		}
	}


	public int getNumberOfPlayers() throws WhatIfNegativeException {
		if(numberOfPlayers < 0) {
			throw new WhatIfNegativeException("The number of players is Negative");
		}
		else {
		return numberOfPlayers;
		}
	}


	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}


	@Override
	public void createSongTitle(String title) {
		this.songTitle = title;
		
	}


	@Override
	public String toString() {
		return "PianoMusic [numberOfPlayers= " + this.numberOfPlayers + ", songTitle= " + this.songTitle +", instrumentUsed= " + this.instrumentUsed +", composer= " + this.composer + "]";
	}
	
	
	
}
