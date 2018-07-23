
public class HelloWorld {
	
	// Declare variables
	// These only belong to this class
	int x;
	int y;
	String z; // String is a type of class with a object, not a primitive datatype

 	// Start execution here!
	// The famous method name main(): must follow this entire method signature
	//		to let the JVM know where to start executing your code
	public static void main(String[] arg) {
		//sysout aka print to the console like console.log
		System.out.println("Hello World!"); // type Sysout then ctrl + spacebar (new best friend)
		//foo();
	//Accessing the function foo w/out having static 
		//HelloWorld is the Datatype of the variable hw
							// create an object of type HelloWorld;
		HelloWorld hw;
		 hw = new HelloWorld();
		hw.foo();
		hw.x = 5;
		hw.y = 10;
		
		HelloWorld hw1 = new HelloWorld();
		hw1.x = 500;
		hw1.y = 1000;
		
		System.out.println(hw.x + " " + hw.y);
		System.out.println(hw1.x + " " + hw1.y);
	}
	
	// A method
	public void foo() {
		System.out.println("foo");
	}
}
