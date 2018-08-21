/**
 * 
 */
package com.revature;

import com.revature.abstracts.Room;
import com.revature.exceptions.TooFewLionsException;
import com.revature.rooms.DarkRoom;

/**
 * @author marci
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DarkRoom r = new DarkRoom();
		populate(r);
		System.out.println(r.toString());
		r.releaseLions();
		
		DarkRoom roomWithDoors = new DarkRoom(2, 0, 2, true);
//		DarkRoom roomWithDoors = new DarkRoom(2, 0, 0, true);
		populate(roomWithDoors);
		roomWithDoors.turnKey();
		System.out.println(roomWithDoors.toString());
		roomWithDoors.releaseLions();
	}
	
	public static void populate(Room r) {
		r.setNumberOfPeople((int)(Math.random()*20));
		try {
			r.setNumberOfLions((int)(Math.random()*20));
		} catch (TooFewLionsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//r.setNumberOfPeople(-1);
	}

}
