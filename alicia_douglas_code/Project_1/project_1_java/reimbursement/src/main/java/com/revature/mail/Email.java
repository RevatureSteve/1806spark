package com.revature.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.revature.domain.Reimbursement;
import com.revature.domain.Users;

public class Email {
	
	/**
	 * Sends email to employee after reimbursement is resolved
	 * @param reim
	 */
	public static void ReimbursementResolvedEmail(Reimbursement reim, Users user) {
		
		final String username = "";
		final String password = "";
		final String receiver = user.getEmail();
		
		String text = "Hello " + reim.getEmployeeName()
				+ "\n\n		Your reimbursement has been " + reim.getRbStatus() + ". \n\n" +
				reim.toString();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(receiver));
			message.setSubject("Reimbursement " + reim.getRbStatus());
			message.setText(text);
			
			Transport.send(message);
			System.out.println("Email Sent");
		} catch (MessagingException e) {
			throw new RuntimeException(e); 
		}
	}
	
	
	/**
	 * Sends email to new employee with account info when manager creates new employee
	 * @param user
	 */
	public static void newUserEmail(Users user) {
		final String username = "";
		final String password = "";
		final String receiver = user.getEmail();
		
		String text = "Hello " + user.getFname() + ", \n\nYour account has been created. Your information is below" 
				+ "\n\nName: " + user.getFname() + " " + user.getLname() 
				+ "\n\nEmail: " + user.getEmail()
				+ "\n\nPassword: " + user.getPassword();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(receiver));
			message.setSubject("New Employee");
			message.setText(text);
			
			Transport.send(message);
			System.out.println("Email Sent");
		} catch (MessagingException e) {
			throw new RuntimeException(e); 
		}
	}

}
