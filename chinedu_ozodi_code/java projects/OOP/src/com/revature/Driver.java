package com.revature;

import com.revature.exceptions.CheckedException;
import com.revature.labels.LabelA;
import com.revature.labels.LabelC;
import com.revature.labels.LabelD;
import com.revature.labels.LabelE;

public class Driver {

	public static void main(String[] args) {
		LabelD lD = new LabelD();
		lD.abstractMethod();
		
		LabelE lE = new LabelE(5,"Hello World", 10, "Foo");
		
		lD.setBaseInt(2);
		lD.setBaseString("No");
		lD.setIntB(5);
		try {
			lD.setStringB("Yes");
		} catch (CheckedException e) {
			e.printStackTrace();
		}
		
		//These will throw an exception
		lE.setIntC(-5);
		
		try {
			lE.setStringC(null);
		} catch (CheckedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LabelA label = new LabelE(5, "Hello",6,"World" );
		
		label.abstractMethod();
		
		((LabelC) label).getStringC();
		
		
		
	}

}
