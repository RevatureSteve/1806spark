
public class HelloWorld {
	
<<<<<<< HEAD
	//declare variables
	int x;
	int y;
	String z;
	// x,y,z belongs to this class, and only this class.

	// Start execution here!
	// Method name main(): must follow this entire method signature.
	// let JVM know where to start executing your code
	public static void main(String[] arg) {
		//sysout aka print to the console, like console.log.
		System.out.println("Hello World!"); 
		/*type Sysout then ctrl+spacebar (itll be a good friend)*/
		HelloWorld hw;
		hw = new HelloWorld();
=======
	// Declare variables
	int x;
	int y;
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
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
		hw.foo();
		hw.x = 5;
		hw.y = 10;
		
<<<<<<< HEAD
		
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
		HelloWorld hw1 = new HelloWorld();
		hw1.x = 500;
		hw1.y = 1000;
		
<<<<<<< HEAD
		System.out.println(hw.x+" "+hw.y);
		System.out.println(hw1.x+" "+hw1.y);
	}
	
	
	public static void foo() {
=======
		System.out.println(hw.x + " " + hw.y);
		System.out.println(hw1.x + " " + hw1.y);
		
	}
	
	
	public void foo() {
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
		System.out.println("foo");
	}
}
