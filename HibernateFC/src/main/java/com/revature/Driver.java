package com.revature;

import com.revature.dao.TodoDaoImpl;
import com.revature.domain.Task;

public class Driver {

	public static void main(String[] args) {
		TodoDaoImpl dao = new TodoDaoImpl();
		Task t = dao.getTaskById(1);
		
System.out.println("TASK IS:" + t);
	}

}