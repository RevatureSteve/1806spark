package com.revature;

import com.revature.abstracts.Attractions;
import com.revature.beans.Lighthouses;
import com.revature.exceptions.NoEmptyStringException;

public class Driver {

	public static void main(String[] args) {

		Lighthouses capeHatteras = new Lighthouses();
		capeHatteras.name = "Cape Hatteras Lighthouse";
		try {
			capeHatteras.setLocation ("Buxton, North Carolina");
		} catch (NoEmptyStringException e) {
			e.printStackTrace();
		}
		capeHatteras.setHeight(210);
		capeHatteras.setWorking(true);
		capeHatteras.setOpen(false);
		Lighthouses curritck = new Lighthouses("Currituck Lighthouse","Corolla, North Carolina", 162, true, true);
		System.out.println(capeHatteras.toString());
		System.out.println(curritck.toString());
		
		openOrClosed(curritck);
		
	}

	
	public static void openOrClosed(Attractions attraction) {
		if(attraction.isOpen()) {
			attraction.setOpen(false);
			System.out.println(attraction.name + " is now closed.");
		} else {
			attraction.setOpen(true);
			System.out.println(attraction.name + " is now open.");
		}
	}
	
}
