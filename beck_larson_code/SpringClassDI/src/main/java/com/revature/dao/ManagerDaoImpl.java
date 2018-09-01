package com.revature.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Employee;
import com.revature.model.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {
	

	@Override
	public Manager getManagerById(int id) {

		return new Manager("Benni", 321, 12);
	}

	@Override
	public List<Manager> getAllManagers(Employee emp) {
		Manager[] Managers = new Manager[] {
				new Manager("Bobby", 221, 22, emp),
				new Manager("Billy", 321, 67, emp),
				new Manager("Nick", 523, 94, emp),
				
		};
		return null;
	}


}
