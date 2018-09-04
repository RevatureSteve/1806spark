package com.ex.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/*
 * This is a Java Mail example using gmail
 * 
 * Maven Dependency (only needed if using Java Project):
  	  <dependency>
 		<groupId>javax</groupId>
		<artifactId>javaee-api</artifactId>
		<version>7.0</version>
	  </dependency>
 * 
 * Note: I have included a jar : mail-1.4.7.jar
 * 		 Only required for a Java Project
 * 
 * Most of the needed objects come from the javax.mail.*; package
 * 
 * Note: You will get a javax.mail.AuthenticationFailedException
 * 		 To fix it you have to enable your gmail account to be accessed by "less secure applications"
 * 		https://myaccount.google.com/lesssecureapps double check you're doing this for only the email
 * 			you account you want to develop / test with DO NOT DO IT WITH YOUR PERSONAL EMAIL
 */
public class Test {
	public static void main(String[] args) {

		/*
		 * You need to change username, password, and receiver
		 */
		final String username = "axel.foley2017@gmail.com";
		final String password = "revature2017";
		final String receiver = "axel.foley2017@gmail.com";
		
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
			message.setSubject("Test Subject");
			message.setText("Hello, World!"
				+ "\n\n This is an awesome email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
