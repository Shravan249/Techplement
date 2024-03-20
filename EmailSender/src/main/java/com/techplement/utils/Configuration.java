package com.techplement.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Configuration {

	public Session getSession() throws IOException {

		Properties props = getProperties();
		String username = Utility.getEmail();
		String password = Utility.getPassword();

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		return session;
	}

	public Properties getProperties() throws IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", Utility.getProperty("host.server"));
		props.put("mail.smtp.port", Utility.getProperty("port.number"));

		return props;
	}
}
