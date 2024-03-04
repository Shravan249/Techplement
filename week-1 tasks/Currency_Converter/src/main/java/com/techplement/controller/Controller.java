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
		while (!options.equals("6")) {
			options = scanner.next();
			try {
				switch (options) {
				case "1":
					System.out.print("Enter currency code to add: ");
					String addCurrency = scanner.next().toUpperCase();
					converter.addFavoriteCurrency(addCurrency);
					Thread.sleep(2000);
					Resources.printMenu();
					break;
				case "2":
					converter.viewFavoriteCurrencies();
					Thread.sleep(2000);
					Resources.printMenu();
					break;
				case "3":
					System.out.print("Enter S.No of currency code to update: ");
					int nums = scanner.nextInt();
					System.out.print("Enter currency code to update: ");
					String updateCurrency = scanner.next().toUpperCase();
					converter.updateFavoriteCurrency(nums, updateCurrency);
					Thread.sleep(2000);
					Resources.printMenu();
					break;
				case "4": 
					System.out.println("Enter first serial number of favorite currencies");
					int code1 = scanner.nextInt();
					System.out.println("Enter second serial number of favorite currencies");
					int code2 = scanner.nextInt();
					System.out.println("Enter the amount to convert");
					BigDecimal amount2 = scanner.nextBigDecimal();
					converter.getExchangeRateFromFavorites(code1, code2, amount2);
					Thread.sleep(2000);
					Resources.printMenu();
				case "5":
					System.out.println("Enter the currency to convert from");
					String convertFrom = scanner.next().toUpperCase();
					System.out.println("Enter the currency to convert to");
					String convertTo = scanner.next().toUpperCase();
					System.out.println("Enter the amount to convert");
					BigDecimal amount = scanner.nextBigDecimal();
					converter.getExchangeRate(convertFrom, convertTo, amount);
					Thread.sleep(2000);
					Resources.printMenu();
					break;
				case "6":
					Resources.printQuitMsg();
					break;

				default:
					System.err.println("Invalid option. Please try again.");
					System.out.println("***************************");
					Resources.printMenu();
				}
			} catch (Exception e) {
				System.err.println("Invalid error occurred..!. Please try again.");
				Resources.printMenu();
			}
		}
		scanner.close();
	}

}
