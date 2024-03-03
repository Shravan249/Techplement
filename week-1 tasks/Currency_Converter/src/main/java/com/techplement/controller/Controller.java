package com.techplement.controller;

import java.math.BigDecimal;
import java.util.Scanner;
import com.techplement.services.Converter;
import com.techplement.utils.Resources;

public class Controller {

	public static void startApp() {
		Converter converter = new Converter();

		Scanner scanner = new Scanner(System.in);
		Resources.printWelcome();
		Resources.printMenu();
		String options = "-1";
		while (!options.equals("5")) {
			options = scanner.next();
			try {
				switch (options) {
				case "1":
					System.out.print("Enter currency code to add: ");
					String addCurrency = scanner.next().toUpperCase();
					converter.addFavoriteCurrency(addCurrency);
					Thread.sleep(3000);

					Resources.printMenu();
					break;
				case "2":
					converter.viewFavoriteCurrencies();
					Thread.sleep(3000);
					Resources.printMenu();
					break;
				case "3":
					System.out.print("Enter S.No of currency to update: ");
					int nums = scanner.nextInt();
					System.out.print("Enter currency code to update: ");
					String updateCurrency = scanner.next().toUpperCase();
					converter.updateFavoriteCurrency(nums, updateCurrency);
					Thread.sleep(3000);
					Resources.printMenu();
					break;
				case "4":
					System.out.println("Type currency to convert from");
					String convertFrom = scanner.next().toUpperCase();
					System.out.println("Type currency to convert to");
					String convertTo = scanner.next().toUpperCase();
					System.out.println("Type amount to convert");
					BigDecimal amount = scanner.nextBigDecimal();
					converter.getExchangeRate(convertFrom, convertTo, amount);
					Thread.sleep(3000);
					Resources.printMenu();
					break;
				case "5":
					Resources.printQuitMsg();
					break;
				default:
					System.err.println("Invalid option. Please try again.");
					System.out.println("***************************");
					Resources.printMenu();
				}
			} catch (Exception e) {
					System.err.println("Invalid error occurred..!");
					Resources.printMenu();
			}
		}
		scanner.close();
	}

}
