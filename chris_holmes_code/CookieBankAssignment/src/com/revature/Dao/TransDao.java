package com.revature.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.interfaces.DataAccess;
import com.revature.pojos.CookieAccount;
import com.revature.pojos.CookieTransaction;

import oracle.jdbc.internal.OracleTypes;

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
		List<Object> LnameList = new ArrayList<>();
		CookieAccount account = CookieAccount.getCurrentAcct();
		try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
		String sql = "{call getLastName(?)";
		String lName = null;
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, account.getActnmbr());
		cs.registerOutParameter(2, OracleTypes.CURSOR);
		cs.executeQuery();
		ResultSet rs = (ResultSet) cs.getObject(2);
		while(rs.next()) {
			CookieTransaction trans = new CookieTransaction();
			LnameList.add(trans);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
				return LnameList;
	}
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
