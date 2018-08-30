package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Manager;

@Repository // aka Dao annotation; also marks as a Component
public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager getManagerById(int id) {
		return new Manager(1, "Steve");
	}

	@Override
	public List<Manager> getAllManagers() {
		return Arrays.asList(new Manager[] {
				new Manager(1, "Steve"),
				new Manager(2, "Mary"),
				new Manager(3, "Sam"),
		});
	}

}
