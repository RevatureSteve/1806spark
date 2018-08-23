package com.revature.service;

import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;
import com.revature.dto.BankUserDTO;
import com.revature.model.BankAccount;
import com.revature.model.BankUser;

public class AppService {
	
	public BankUser validateUser(BankUser user){
		
		BankUserDao dao = new BankUserDaoImpl();
		
		// get a BankUser Object back from the DAO
		BankUser dbUser = dao.getUserByUsername(user);
		if(dbUser != null){
			if( dbUser.getUsername().equals(user.getUsername() )  
					&& dbUser.getPassword().equals(user.getPassword())){
				return dbUser;
			}
		}
		return null;
		
	}

	
	public BankUserDTO convertToBankUserDTO(BankUser user, BankAccount bankAccount){
		
		return new BankUserDTO(user.getId(),user.getUsername(),user.getFirstName(),user.getLastName(), bankAccount.getBaId(), bankAccount.getBaBalance());
		
	} 
	
	public BankAccount getBankAccountByUsername(BankUser user){
		return new BankUserDaoImpl().getBankAccountByUserId(user);	}
}
