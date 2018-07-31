package com.revature.javaAssignment1.abstracts;

import java.io.Serializable;

public interface Music extends Serializable{
	
	boolean beatAlive = true;
	

	void printLengthOfSong(double songLength);
	
	default void createSongTitle(String title) {
		
		System.out.println("Title is " + title);
		
	}
	
	
	
	
	
	
	

}
