package com.techplement.EmailSender;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {

		String email = "dsuchithra670@gmail.com";
		String subject = "Testing Email Sender";
		String message = "Dear Candidate,\n\nThis is a test email...!";

		EmailSender emailSender = new EmailSender();
		emailSender.sendMessage(email, subject, message);
	}
}
