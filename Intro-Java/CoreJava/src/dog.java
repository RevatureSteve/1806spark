
public class dog extends pet{
private String breed;

public dog(String name, int age, boolean isAlive, String breed) {
	super(name, age, isAlive);
	// TODO Auto-generated constructor stub
}

public String getBreed() {
	return breed;
}

public void setBreed(String breed) {
	this.breed = breed;
}

@Override
public void speak() {
	// TODO Auto-generated method stub
	System.out.println(this.getName() + " barks");
}

}
