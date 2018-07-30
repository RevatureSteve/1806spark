public class Employee {
	
	String name;
	int age;
	String designation;
	double salary;
	
//	constructor of class Employee
	public Employee(String name) {
		this.name = name;
	}
	
//	assign the age of the employee to the variable age
	public void empAge(int empAge) {
		age = empAge;
	}
	
//	assign the designation to the variable designation
	
	public void empDesignation(String empDesig) {
		designation = empDesig;
	}
	
//	assign the salary to the variable salary
	public void empSalary(double empSalary) {
		salary = empSalary;
	}

// print the employee details
public void printEmployee() {
System.out.println("Name:" + name);
System.out.println("Age:" + age);
System.out.println("Designation:" + designation);
System.out.println("Salary:" + salary);
}

}