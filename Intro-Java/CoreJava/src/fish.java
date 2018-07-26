
public class fish extends pet{
private int numberOfFins;

public fish(String name, int age, boolean isAlive, int numberOfFins) {
	super(name, age, isAlive);
	this.numberOfFins = numberOfFins;
}

public int getNumberOfFins() {
	return numberOfFins;
}

public void setNumberOfFins(int numberOfFins) {
	this.numberOfFins = numberOfFins;
}

@Override
public void speak() {
	// TODO Auto-generated method stub
	System.out.println(this.getName() + " bubbles.");
}


}
