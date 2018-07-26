
public class launcher {
	
public static void main(String[] args) {
	dog henry = new dog("henry", 42, true, "husky");
	System.out.println(henry.getName());
	fish johnson = new fish("johnson", 50, false, 2);
	System.out.println(johnson.getNumberOfFins());
	bird barry = new bird("barry", 2, true, "red");
	System.out.println(barry.getName());
	dog spot = new dog("Spot", 5, true, "dalmation");
	fish nickel = new fish("nikcel", 13, false, 5);
	bird lucy = new bird("lucy", 2, false, "blue");
	
	//Array for pets.
pet[] petArray = new pet[5];
	petArray[0] = henry;
	petArray[1] = johnson;
	petArray[2] = barry;
	petArray[3] = spot;
	petArray[4] = nickel;
	

//Loop.
for(pet element: petArray) {
	element.speak();
}
	
	
	
	
	
	
	
	
}




}
