package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.domain.Employee;
import com.revature.domain.Manager;

@Repository //aka the Dao annotation; also marks as a component
public class ManagerDaoImpl implements ManagerDao {

	public Manager getMangerbyId(int id) {
		return new Manager("Robbert",23,"CTO");
	}

	public List<Manager> getAllManagers() {
		Integer[] spam = new Integer[] {1, 2, 3};
		Arrays.asList(spam);
		
		Manager[] manager = new Manager[] {
				new Manager("Stephen",28 ,"Head Chef"),
				new Manager("Daniel",25 ,"Regional Manager"),
				new Manager("Max",52 ,"BTO")
		};
		return Arrays.asList(manager);
	}
	
	 

}
