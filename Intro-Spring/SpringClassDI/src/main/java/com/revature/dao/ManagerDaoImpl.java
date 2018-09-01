package com.revature.dao;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Manager;

=======
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Manager;

@Repository // aka Dao annotation; also marks as a Component
>>>>>>> 0859023c77c3912cdd1b0fc58087b1984fdb1be1
public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager getManagerById(int id) {
<<<<<<< HEAD
		return new Manager(1, "Bobbert");
=======
		return new Manager(1, "Steve");
>>>>>>> 0859023c77c3912cdd1b0fc58087b1984fdb1be1
	}

	@Override
	public List<Manager> getAllManagers() {
<<<<<<< HEAD
		ArrayList<Manager> mgrs = new ArrayList<Manager>();
		mgrs.add(new Manager(2, "Bob"));
		mgrs.add(new Manager(3, "Rob"));
		return mgrs;
=======
		return Arrays.asList(new Manager[] {
				new Manager(1, "Steve"),
				new Manager(2, "Mary"),
				new Manager(3, "Sam"),
		});
>>>>>>> 0859023c77c3912cdd1b0fc58087b1984fdb1be1
	}

}
