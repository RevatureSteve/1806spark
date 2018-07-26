
public class bird extends pet {
private String color;

public bird(String name, int age, boolean isAlive, String color) {
	super(name, age, isAlive);
	this.color = color;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

@Override
public void speak() {
	// TODO Auto-generated method stub
	System.out.println(this.getName() + " tweaks");
} 


}
