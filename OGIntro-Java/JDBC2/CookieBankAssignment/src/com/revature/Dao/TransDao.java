package com.revature.Dao;

import java.util.List;

import com.revature.interfaces.DataAccess;

public class TransDao implements DataAccess {
	
	private final static String USERNAME = "bank_db"; //Username from database
	private final static String PASSWORD = "p4ssw0rd"; // password from database
	private final static String URL = "jdbc:oracle:thin:@octocat.ckichuqa168o.us-east-2.rds.amazonaws.com:1521:ORCL";
	// jdbc:oracle:thin@octocat + hostname
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
