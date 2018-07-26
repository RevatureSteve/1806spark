
public class HelloWorld {
	
	//declaring variable
	int x, y;  // or int x; int y;
	String z;
	
	//start execution here!
	//the famous method name main(): must follow this entire signature
	//to let java know the JVM where to start executing your code
	public static void main(String[] arg) {
		// public mean that the code is available for other user to see (developers not regular users)
		// static mean that it only available too the helloWorld class. static is a scope 
		// sysout aka print to the console.log
		System.out.println("hello world"); // type sysout the control + spacebar (new best friend)  
		//foo(); // you call foo from here to be invoke
		
		//first helloworld is the datatype of the object of the hw variable
						// create an object of the type HelloWorld
		HelloWorld hw = new HelloWorld();
		hw.foo();
		
		hw.foo();
		hw.x = 5;
		hw.y = 10;
		
		HelloWorld hw1 = new HelloWorld();
		hw1.x = 500;
		hw1.y = 1000;
		
		System.out.println(hw.x +" " + hw.y);
		System.out.println(hw1.x +" " + hw1.y);
		
		
		// or HElloWorld hw;
		// hw = new HelloWorld();
	}
	
	public void  foo() {
		// if static is remove, the scope changes and it wont be able to be seen in the main()
		// from this location foo will never get called because it isn't invoke
		
		System.out.println("Foo");
	}
	
	
}
