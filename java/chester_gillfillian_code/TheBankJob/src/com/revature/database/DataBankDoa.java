package com.revature.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import com.revature.pojo.Account;
import com.revature.pojo.Users;

public class DataBankDoa implements  Doa{
	
	
		private static final String USERNAME = "bank_db";

		private static final String PASSWORD = "p4ssw0rd";

		private static final String URL = "jdbc:oracle:thin:@octocat.czuadbiw1r4y.us-east-2.rds.amazonaws.com:1521:ORCL";
		



		// CEATE
 


		// READ

		@Override

		public Users confirmUser(String userName, String passWord) {

			

			Users user = null;

			Users singUsers = Users.getInstance(); // this is how you initialize a singleton/call it
			// make sure when call/initializing singleton to the right of the = sign put the class name . get what ever you call variable
			// this one is created in Users.java Chester to Chester...don't be a bone head review it
			
			
			
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {

				String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, userName);

				ps.setString(2, passWord);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

////////// error below was fixed by //  hover over and generating constructor with new values
				//	to add into the paramater in user .java
					
					user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), 

							rs.getString(4), rs.getString(5));
					
					
					singUsers.setUsersId(rs.getInt(1)); // user id
					singUsers.setUsername(rs.getString(2));    // 
					singUsers.setFirstname(rs.getString(4));  // first name
					singUsers.setLastname(rs.getString(5));    // last name
					singUsers.setPassword(rs.getString(3));    //password very bad practice
					

				}

				System.out.println("Welcome back, " + user.getFirstname() + " " + user.getLastname() + "\n");
/// this is where the welcome null null came up
			} catch (SQLException e) {

				System.out.println("Sorry but that account is not found in our records.\n");

				e.printStackTrace();

			} catch (NullPointerException e) {

				System.out.println("Username or Password is incorrect.\n");	

			}

			return user;

		}

		

	  @Override

		public void getAccountInfo(int usersId) {



			

			Account account = null;
// link to account.java fix with import
			
			Account accountSing = Account.accountSingleton();
			
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {

				String sql = "SELECT * FROM bank_account WHERE users_id = " + usersId;

				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					account = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
// link to account.java fix with import
					
					accountSing.setAccountNumber(rs.getInt(1)); // account number
					accountSing.setBalance(rs.getDouble(2));    // balance
					accountSing.setUsersId(rs.getInt(3));		// user id
				}

				//System.out.println("Available balance is $" + df.format(account.getBalance()) + "\n");

			} catch (SQLException e) {

				e.printStackTrace();

			}


		}



		// UPDATE

		@Override

		public void setDepositAmount(int bankAccountNumber, double depositAmount) {




			int rowAffected = 0;

			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {

				String sql = "{CALL deposit_trans(?, ?)}";

				CallableStatement cs = conn.prepareCall(sql);

				cs.setInt(2, bankAccountNumber);

				cs.setDouble(1, depositAmount);

				rowAffected = cs.executeUpdate();

				if (rowAffected == 1) {

//					System.out.println("$" + df.format(depositAmount) + " has been deposited to your account.\n");

				} else {

					System.out.println("The transaction could not be completed at this time\n");

				}

			} catch (SQLException e) {

				e.printStackTrace();

			}



		}



		@Override

		public void setWithdrawAmount(int bankAccountNumber, double withdrawAmount) {



//			
			int rowAffected = 0;

			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {

				String sql = "{CALL withdraw_money(?, ?)}";

				CallableStatement cs = conn.prepareCall(sql);

				cs.setInt(2, bankAccountNumber);

				cs.setDouble(1, withdrawAmount);

				rowAffected = cs.executeUpdate();

				if (rowAffected == 1) {

//				
				} else {

					System.out.println("The transaction could not be completed at this time\n");

				}

			} catch (SQLException e) {

				e.printStackTrace();

			}



		}



		// DELETE



	

}
