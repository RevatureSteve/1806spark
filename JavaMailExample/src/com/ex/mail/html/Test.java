package com.ex.mail.html;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test {
	
	public static void sendEmail(String subject, String content){
		
		/*
		 * You need to change username, password, and receiver
		 */
		final String username = "xyz@gmail.com";
		final String password = "password";
		final String receiver = "abc@gmail.com";

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

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(receiver));
			message.setSubject(subject);
			message.setText(content, "utf-8", "html");			

			Transport.send(message);
			
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getContent(){
		String fileName = "src/test.html";
		String content = "";

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName),
                    Charset.defaultCharset());
            for (String line : lines) {
            	content += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
	}
	
	
	public static void main(String[] args) {
		String subject = "Hey";
		String content = getContent();        

        sendEmail(subject, content);
		
	}
}
