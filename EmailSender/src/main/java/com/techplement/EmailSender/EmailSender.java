package com.techplement.EmailSender;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.techplement.utils.Configuration;
import com.techplement.utils.Utility;

public class EmailSender {

	public void sendMessage(String email, String subject, String message) throws IOException {

		Configuration config = new Configuration();
		String username = Utility.getEmail();
		try {
			Message messagener = new MimeMessage(config.getSession());
			messagener.setFrom(new InternetAddress(username));
			messagener.setSubject(subject);
			// Set the recipient email address
			String recipientEmail = email;
			messagener.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
			// Set the email body
			messagener.setText(message);
			// Send the email
			Transport.send(messagener);
			System.out.println("Email sent successfully to: " + recipientEmail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
