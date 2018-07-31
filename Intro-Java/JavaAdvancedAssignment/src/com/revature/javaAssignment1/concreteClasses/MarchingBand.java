package com.revature.javaAssignment1.concreteClasses;

import com.revature.javaAssignment1.exceptions.SometimesNullException;

public class MarchingBand extends TrumpetBand{
	
	private String marchingbandName;
	private int numOfMembers;
	private String songTitle;
	
	public MarchingBand() {
		super();
		System.out.println("Creating a marching band");
	}

	public MarchingBand(String instrumentUsed, String bandName, int numOfMembers,String songTitle) {
		
		this.instrumentUsed = instrumentUsed;
		this.marchingbandName = bandName;
		this.numOfMembers = numOfMembers;
		this.songTitle = songTitle;
	}
	
	@Override
	public String getBandName() throws SometimesNullException {
		// TODO Auto-generated method stub
		return super.getBandName();
	}

	@Override
	public void setBandName(String bandName) {
		
		System.out.println("hi");
	}

	public String getMarchingbandName() {
		return marchingbandName;
	}

	public void setMarchingbandName(String marchingbandName) {
		marchingbandName = marchingbandName;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	
	
	@Override
	public String toString() {
		return "Marching Band [Number Of Members= " + this.numOfMembers + ", songTitle= " + this.songTitle +", instrumentUsed= " + this.instrumentUsed +", Marching Band Name= " + this.marchingbandName + "]";
	}
	
	

}
