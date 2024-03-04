package com.techplement.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import com.techplement.utils.Resources;

public class Converter {

	private Map<Integer, String> favoriteCurrencies;
	private int count = 0;

	public Converter() {
		favoriteCurrencies = new HashMap<>();
	}

	public void addFavoriteCurrency(String currency) {
		favoriteCurrencies.put(++count, currency);
		System.out.println("Added sucessfully...");
	}

	public void viewFavoriteCurrencies() {
		System.out.println("Favorite Currencies:");
		for (Map.Entry<Integer, String> entry : favoriteCurrencies.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public void getExchangeRateFromFavorites(int code1, int code2, BigDecimal amount) {

		if (favoriteCurrencies.isEmpty()) {
			System.err.println("Favorite currencies is empty. Please add currencies..!");
		} 
		else {
			if (favoriteCurrencies.containsKey(code1) && favoriteCurrencies.containsKey(code2)) {
				String firstContryCode = favoriteCurrencies.get(code1);
				String secondContryCode = favoriteCurrencies.get(code2);
				getExchangeRate(firstContryCode, secondContryCode, amount);

			} else {
				System.err.println("Key not found in favorites.");
			}
		}
	}

	public void updateFavoriteCurrency(int num, String currency) {
		if (favoriteCurrencies.containsKey(num)) {
			favoriteCurrencies.put(num, currency);
			System.out.println("Updated successfully.");
		} else {
			System.out.println("Currency not found in favorites.");
		}
	}

	public void getExchangeRate(String convertFrom, String convertTo, BigDecimal amount) {
		try {
			String stringResponse = Resources.getApiResponse(convertFrom);
			JSONObject jsonObject = new JSONObject(stringResponse);
			JSONObject ratesObject = jsonObject.getJSONObject("conversion_rates");
			BigDecimal rate = ratesObject.getBigDecimal(convertTo);
			BigDecimal result = rate.multiply(amount);
			System.out.println(result);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
