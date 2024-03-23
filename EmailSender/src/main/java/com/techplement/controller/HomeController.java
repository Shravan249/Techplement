package com.techplement.controller;

import java.util.Scanner;

import com.techplement.services.EmailSender;
import com.techplement.utils.Utility;

public class HomeController {

	public static void startApp() {
		EmailSender emailSender = new EmailSender();

		Scanner scanner = new Scanner(System.in);
		Utility.printWelcome();
		Utility.printMenu();
		String options = "-1";
		while (!options.equals("2")) {
			options = scanner.next();
			try {
				switch (options) {
				case "1":
					System.out.print("Enter recipient Mail : ");
					String recipientMail = scanner.next();
					scanner.nextLine(); // Consume newline
					System.out.print("Enter Subject of the Mail : ");
					String subject = scanner.nextLine(); // Capture entire line for subject
					System.out.println("Enter the Message (type 'END' on a new line to finish): ");
					StringBuilder messageBuilder = new StringBuilder();
					String line;
					while (!(line = scanner.nextLine()).equalsIgnoreCase("END")) {
						messageBuilder.append(line).append("\n");
					}
					String message = messageBuilder.toString().trim(); // Remove trailing newline
					emailSender.sendMessage(recipientMail, subject, message);
					Utility.printMenu();
					break;

				case "2":
					Utility.printQuitMsg();
					break;

				default:
					System.err.println("Invalid option. Please try again.");
					System.out.println("***************************");
					Utility.printMenu();
				}
			} catch (Exception e) {
				System.err.println("Invalid error occurred..!. Please try again.");
				Utility.printMenu();
			}
		}
		scanner.close();
	}
}
