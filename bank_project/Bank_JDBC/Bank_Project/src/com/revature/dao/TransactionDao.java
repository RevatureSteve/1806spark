package com.revature.dao;

import java.util.List;

import com.revature.interfaces.Dao;

public class TransactionDao implements Dao{
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@mydbinstance.cu3okwucelpd.us-east-2.rds.amazonaws.com:1521:ORCL";
	

	@Override
	public int create(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
