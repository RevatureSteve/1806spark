package com.revature.pojos;

public class CookieAccount {
	
	private int actnmbr;
	private int bal;
	private int userId;
 
	private static CookieAccount currentAcct = null;
	
	public CookieAccount() {}

	public CookieAccount(int actnmbr, int bal, int userId) {
		super();
		this.actnmbr = actnmbr;
		this.bal = bal;
		this.userId = userId;
	}
	
	public static void createCookieAccount(int actnmbr, int bal, int userId){
		currentAcct = new CookieAccount(actnmbr, bal, userId);
		
	}
	
	public void createCookieAccount() {}

	public int getActnmbr() {
		return actnmbr;
	}

	public void setActnmbr(int actnmbr) {
		this.actnmbr = actnmbr;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static CookieAccount getCurrentAcct() {
		return currentAcct;
	}

	public static void setCurrentAcct(CookieAccount currentAcct) {
		CookieAccount.currentAcct = currentAcct;
	}

	@Override
	public String toString() {
		return "CookieAccount [actnmbr=" + actnmbr + ", bal=" + bal + ", userId=" + userId + "]";
	}
	
	
	
	
}
