package com.revature;
public abstract class Reptile {
	
	

	// state aka variables
private Boolean hasScales;
protected Boolean coldBlooded;
public  String[] name;


//No ARGS constructor, future frameworks will require this 
public Reptile() {
}

public Reptile(Boolean hasScales, Boolean coldBlooded, String[] name) {

this.hasScales = hasScales;
this.coldBlooded = coldBlooded;
this.name = name;

}

//Behavior
public String[] getName() {

return name; 
}

private Boolean getScales() {
	return hasScales;
}
//Auto generated from override
public String[] feedRat() {
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
	this.hasScales = hasScales;
}




}




