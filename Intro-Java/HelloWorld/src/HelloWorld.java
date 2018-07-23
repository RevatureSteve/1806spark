
public class HelloWorld {
	
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
		hw.foo();
		hw.x = 5;
		hw.y = 10;
		
		
		HelloWorld hw1 = new HelloWorld();
		hw1.x = 500;
		hw1.y = 1000;
		
		System.out.println(hw.x+" "+hw.y);
		System.out.println(hw1.x+" "+hw1.y);
	}
	
	
	public static void foo() {
		System.out.println("foo");
	}
}
