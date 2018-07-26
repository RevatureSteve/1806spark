package com.phones.drake;

public class Driver {
	
	public static void main(String[] args) {
		
		// debugging for this instantiation is interesting
		SmartPhone s = new SmartPhone("blue");
		Phone l = new LandLine();
		
		s.listProperties();
		l.listProperties();
		
		System.out.println(Phone.isUnplugged);
		// smartphone and landline can plug/unplug each other
		SmartPhone.togglePlug(l);
		
		System.out.println(Phone.isUnplugged);
		
	}

}
