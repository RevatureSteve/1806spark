<<<<<<< HEAD
=======

>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
public class HelloWorld {
	
	// Declare variables
	int x;
	int y;
<<<<<<< HEAD
	String z;
	
	// Start execution here
	public static void main(String[] args) {
		// Print to console
		System.out.println("Hello World!");
//		foo();
		HelloWorld hw = new HelloWorld();
		hw.foo();
		
=======
//	String z; 
	
	
	// Start execution here!
	// The famous method name main(): must follow this entire method signature
	//		to let the JVM know where start executing your code
	public static void main(String[] arg) {
		// sysout aka print to the console like console.log
		System.out.println("Hello World!"); // type Sysout then ctrl + spacebar (new best friend)
//		foo();
		//HelloWorld is the Datatype of the variable hw
						// create an object of type HelloWorld;
		HelloWorld hw;
		 hw = new HelloWorld();
		hw.foo();
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
		hw.x = 5;
		hw.y = 10;
		
		HelloWorld hw1 = new HelloWorld();
		hw1.x = 500;
		hw1.y = 1000;
		
		System.out.println(hw.x + " " + hw.y);
		System.out.println(hw1.x + " " + hw1.y);
<<<<<<< HEAD
	}

=======
		
	}
	
	
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	public void foo() {
		System.out.println("foo");
	}
}
