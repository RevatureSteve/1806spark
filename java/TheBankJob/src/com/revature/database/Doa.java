package com.revature.database;

import com.revature.pojo.Account;
import com.revature.pojo.Users;

public interface Doa {
	

		// CREATE



		// READ

		public Users confirmUser(String username, String password);

		

		public void getAccountInfo(int userId);



		// UPDATE

		public void setDepositAmount(int bankAccountNumber, double depoAmount);

		

		public void setWithdrawAmount(int usersId4, double withAmount);



		// DELETE



	

}
