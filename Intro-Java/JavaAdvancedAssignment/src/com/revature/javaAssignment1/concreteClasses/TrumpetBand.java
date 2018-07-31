package com.revature.javaAssignment1.concreteClasses;

import com.revature.javaAssignment1.abstracts.Classical;
import com.revature.javaAssignment1.abstracts.Music;
import com.revature.javaAssignment1.exceptions.NoLetterSException;
import com.revature.javaAssignment1.exceptions.SometimesNullException;



public class TrumpetBand extends Classical implements Music{
	
	private String bandName;
	private int numOfMembers;
	private String songTitle;
	

	public TrumpetBand() {
		super();
		System.out.println("Creating new trumpet music");
	}
	
	
	public TrumpetBand(String instrumentUsed, String bandName, int numOfMembers,String songTitle) {
	
		this.instrumentUsed = instrumentUsed;
		this.bandName = bandName;
		this.numOfMembers = numOfMembers;
		this.songTitle = songTitle;
	}

	

	@Override
	public void playInstrument() {
		System.out.println("Start playing music with piano");
		
	}


	@Override
	public void printLengthOfSong(double songLength) {

		System.out.println("The song is " + songLength + " mins long");

	}


	public String getBandName() throws SometimesNullException {
		
		if(this.bandName == null) {
			throw new SometimesNullException();
		}
		return bandName;
	}


	public void setBandName(String bandName) {
		if(bandName.charAt(0) == 'S' || bandName.charAt(0) == 's') {
			throw new NoLetterSException("Band Name cannot start with an S");
		}
		this.bandName = bandName;
	}


	public int getNumOfMembers() {
		return numOfMembers;
	}


	public void setNumOfMembers(int numOfMembers) {
		
		this.numOfMembers = numOfMembers;
	}


	@Override
	public void createSongTitle(String title) {
		this.songTitle = title;
		
	}
	
	@Override
	public String toString() {
		return "TrumpetBand [Number Of Members= " + this.numOfMembers + ", songTitle= " + this.songTitle +", instrumentUsed= " + this.instrumentUsed +", Trumpet Band Name= " + this.bandName + "]";
	}


}
