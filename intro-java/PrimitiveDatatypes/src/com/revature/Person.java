package com.revature;

// POJO: Plain old java object aka no entry point but has state/behaviour
public class Person extends Object{
	
	   /*
	    * public and private access modifier
	    *     public: any developer can see it
	    *     private: only reference private variables or methods from inside the same class
	    */
	
	    // state: variables at the instance level scope ( not static and not nested inside an method)
	 public String name;
	 public int age;
	 public double height;
	 public boolean isAlive;
	 public char gender;
	   
	   
	 // create a constructor: it takes in the values to set the object's state
	 //        constructors follow very strict syntax
	 //             - no return type, it returns the object
	 //             - the name is the same as the class
	 //             - can have nay access modifier
	  public Person (){
		  System.out.println("Making a person object");
		 
	 }
	               // when method/constructor parameter have the smae name as the instance variable: shadowing
	  public Person (String name, int age, double height, boolean isAlive, char gender){
		  this.name = name;
		  this.age = age;
		  this.height = height;
		  this.isAlive = isAlive;
		  this.gender = gender;
		  System.out.println("Making a person object w/ parameters");
		 
	 }
	  /*
	   * constructor/methods with the same name but different parameters inside the same class: overloading IQ
	   */
	  // Create a constructor with only name, age, height
	  public Person (String name, int age, double height) {
		  super(); // the first line of every constructor is super() by DEFAULT!!
		  this.name = name;
		  this.age = age;
		  this.height = height;
	  }
	        
	   //behavior: methods
	   public void walk(){
		   System.out.println("I am walking");
	   }
	
      public String speak(){
    	   return "I am speaking";
       }
     // method overriding: changing the implementation of a parent method: same name and same parameters
     // note you do not inherit constructors, so you cannot override them
	@Override // @ means annotation
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}
      
}
