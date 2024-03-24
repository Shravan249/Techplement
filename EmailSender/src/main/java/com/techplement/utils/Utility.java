package com.techplement.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

	public static String getProperty(String key) throws IOException {

		FileInputStream fs = new FileInputStream(new File("./src/main/resource/Config.properties"));
		Properties prop = new Properties();
		prop.load(fs);
		return prop.getProperty(key);
	}

	public static String getEmail() throws IOException {
		String username = Utility.getProperty("username");
		return username;
	}

	public static String getPassword() throws IOException {

		String password = Utility.getProperty("password");
		return password;
	}
	

}
