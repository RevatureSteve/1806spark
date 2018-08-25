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

public class Email {

	public static void ReimbursementResolvedEmail(Reimbursement reim) {
		
		final String username = "";
		final String password = "";
		final String receiver = "";
		
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

}
