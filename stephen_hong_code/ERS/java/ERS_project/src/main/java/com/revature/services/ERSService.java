package com.revature.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ERSService {
	private static UserDAO userDao = new UserDAOImpl();
	private static ReimbursementDAO reimbDao = new ReimbursementDAOImpl();

	public User createNewUser(User user) {
		System.out.println("[LOG] - In ERSService.createNewUser()");
		User newUser = null;

		boolean emailAvailable = isEmailAvailable(user.getEmail());
		boolean usernameAvailable = isUsernameAvailable(user.getUsername());

		if(emailAvailable && usernameAvailable) {
			newUser = userDao.createUser(user);
		}

		return newUser;
	}

	public User getUserById(int id) {
		System.out.println("[LOG] - In ERSService.getUserById()");
		return userDao.getUserById(id);
	}

	public User getUserByEmail(String email) {
		System.out.println("[LOG] - In ERSService.getUserByEmail()");
		return userDao.getUserByEmail(email);
	}
	//check
	public User getUserByUsername(String username) {
		System.out.println("[LOG] - In ERSService.getUserByUsername()");
		return userDao.getUserByUsername(username);
	}
	//check
	public static ArrayList<User> getAllUsers(){
		System.out.println("[LOG] - In ERSService.getAllUsers()");
		return userDao.getAllUsers();
	}

	public boolean isEmailAvailable(String email) {
		System.out.println("[LOG] - In ERSService.isEmailAvailable()");
		email = email.toLowerCase();
		User u = userDao.getUserByEmail(email);
		return u == null;
	}

	public boolean isUsernameAvailable(String username) {
		System.out.println("[LOG] - In ERSService.isUsernameAvailable()");
		username = username.toLowerCase();
		User u = userDao.getUserByUsername(username);
		return u == null;
	}
	//check
	public Reimbursement createReimbursement(Reimbursement r) {
		System.out.println("[LOG] - In ERSService.createReimbursement()");
		Reimbursement reimb = null;
		reimb = reimbDao.createReimbursement(r);
		return reimb;
	}
	//check
	public static ArrayList<Reimbursement> getAllReimbursements() {
		System.out.println("[LOG] - In ERSService.getAllReimbursements()");
		return reimbDao.getAllReimbursements();
	}
	
	public Reimbursement updateReimbursement(Reimbursement r) {
		System.out.println("[LOG] - In ERSService.updateReimbursement()");
		Reimbursement reimb = null;
		reimb = reimbDao.updateReimbursement(r);
		return reimb;
	}

	public Reimbursement getReimbursementById(int id) {
		System.out.println("[LOG] - In ERSService.getReimbursementById()");
		return reimbDao.getReimbursementById(id);
	}
	//check
	public ArrayList<Reimbursement> getUserReimbursements(User user){
		System.out.println("[LOG] - In ERSService.getUserReimbursements()");
		return reimbDao.getReimbursementsForUserId(user.getId());
	}
	//check
	public String generateSalt() {
		System.out.println("[LOG] - in ERSService.generateSalt()");
		RandomString rs = new RandomString(16);
		return rs.nextString();
	}
	//check
	public String hashPassword(String password, String salt) {
		System.out.println("[LOG] - In ERSService.hashPassword()");
		try {
			//Use SHA-256 algorithm to generate a 256-bit (32-byte) hash
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return bytesToHex(digest.digest((password + salt).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			return null;
		}
	}
	//check
	public String bytesToHex(byte[] bytes) {
		System.out.println("[LOG] - In ERSService.bytesToHex()");
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for ( int j = 0; j < bytes.length; j++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
	//check
	private static class RandomString {
		//Generate a random string.
		public String nextString() {
			System.out.println("[LOG] - RandomString.nextString()");
			for (int idx = 0; idx < buf.length; ++idx)
				buf[idx] = symbols[random.nextInt(symbols.length)];
			return new String(buf);
		}

		public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		public static final String lower = upper.toLowerCase(Locale.ROOT);

		public static final String digits = "0123456789";

		public static final String alphanum = upper + lower + digits;

		private final Random random;

		private final char[] symbols;

		private final char[] buf;

		public RandomString(int length, Random random, String symbols) {
			if (length < 1) throw new IllegalArgumentException();
			if (symbols.length() < 2) throw new IllegalArgumentException();
			this.random = Objects.requireNonNull(random);
			this.symbols = symbols.toCharArray();
			this.buf = new char[length];
		}

		//Create an alphanumeric string generator.
		public RandomString(int length, Random random) {
			this(length, random, alphanum);
		}

		//Create an alphanumeric strings from a secure generator.
		public RandomString(int length) {
			this(length, new SecureRandom());
			System.out.println("[LOG] - SecureRandom()");
		}
	}
}
