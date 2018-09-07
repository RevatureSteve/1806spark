package com.revature.repository;

import org.springframework.stereotype.Component;

@Component //component for now, will use @Repository once we get to Spring ORM/DATA
public class EmployeeRepo implements EmpRepo{

	public String findEmployee() {
		System.out.println("Repo found Bobbert");
		return "Bobbert";
	}

}
