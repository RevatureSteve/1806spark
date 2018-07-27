package com.revature;
public abstract class Reptile {
	
	

	// state aka variables
private Boolean hasScales;
protected Boolean coldBlooded;
public  String name;


//No ARGS constructor, future frameworks will require this 
//if I made a reptile with no arguments I would need this constructor to set the values later
//to create default value
public Reptile() {
}

//another constructor
public Reptile(Boolean hasScales, Boolean coldBlooded, String name) {

this.hasScales = hasScales;
this.coldBlooded = coldBlooded;
this.name = name;

}

//Behavior
public String getName() { // returns the data thats been stored in name

return name; 
}


public void setName(String name) throws NoNameException { // allows me to insert/edit values
	this.name = name;
	if (name == "") {
		System.out.println("reptiles have names too");
		this.name = "snake";
		throw new NoNameException();
	}else {
		this.name = name;
	}
}

private Boolean getScales() throws NoScalesException {
	return hasScales;

}
//Auto generated from override
public String feedRat() {
	// TODO Auto-generated method stub
	return this.name;
}
//Auto generated from override
public Boolean heatResistance() {
	// TODO Auto-generated method stub
	return true;
}
// generating getters and setters for private variable
public Boolean getHasScales() {
	return hasScales;
}
//Setters
public void setHasScales(Boolean hasScales) {
	if (hasScales == false) {
		System.out.println("WHAT KIND OF SNAKE DOESN'T HAVE SCALES?");
		this.hasScales = true;
		throw new NoScalesException(); //this should be doing println
	}else {
		this.hasScales = hasScales;
	}
}




}




