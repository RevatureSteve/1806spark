package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Transaction;

import oracle.jdbc.internal.OracleTypes;

public class TransactionDaoImpl implements TransactionDao{
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@hearthstone.cxazmpz2rlnm.us-east-2.rds.amazonaws.com:1521:ORCL";

	@Override
	public int createTx(Transaction tx) {
		Transaction trans = (Transaction) tx;
		//set transaction info with user input amount
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call create_bank_tx(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			//calling SQL stored procedure without the parameter values
			cs.setDouble(1, trans.getTxAmt());
			//this is what goes inside the 1st ?, user input amount
			cs.setString(2, trans.getTxType());
			//this is what goes inside the 2st ?, deposit or withdrawal
			cs.setInt(3, trans.getAcNum());
			//this is what goes inside the 3st ?, current account's number
			System.out.println("Transaction was successful");
			rowsAffected = cs.executeUpdate();
			//inserted new row to Bank_Tx table in SQL
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public List<Transaction> readTx() {
		List<Transaction> transaction = new ArrayList<>();
		BankAccount account = BankAccount.getCurrentAccount();
		//set account as current account
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call tx_history(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//calling SQL stored procedure without the parameter values
			cs.setInt(1, account.getAcNum());
			//this is what goes inside the 1st ?, current account's number
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			//this is what goes inside the 2nd ?
			//A cursor is a pointer to a result set for a query
			//By returning a sys_refcursor, you can fetch as many or few of the rows from the query as it requires
			cs.executeQuery();
			//Use executeQuery for SELECT
			ResultSet rs = (ResultSet) cs.getObject(2);
			//Retrieves the value of the designated parameter as an Object 
			//the Object type corresponds to the JDBC type that was registered for this parameter using the method registerOutParameter
			
			//put in the account number(1st ?) to get transaction history for that particular account(2nd ?)
			//Retrieve transaction history for the current user and give it to the ResultSet
			
			while(rs.next()) {
				Transaction tx = new Transaction(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString("tx_type"), rs.getInt(5));
				transaction.add(tx);
				//loop through and select transactions from the table and add them to the list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transaction;
	}

}
