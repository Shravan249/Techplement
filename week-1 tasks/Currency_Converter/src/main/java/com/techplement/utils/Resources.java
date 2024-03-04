package com.techplement.utils;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Resources {

	public static String getApiResponse(String convertFrom) throws IOException {
		String urlString = getApiUrl() + convertFrom;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(urlString).get().build();
		Response response = client.newCall(request).execute();

		String stringResponse = response.body().string();
		return stringResponse;
	}

	public static String getApiUrl() {
		final String API_URL = "https://v6.exchangerate-api.com/v6/" + APIConstants.API_KEY.getValue() + "/latest/";
		return API_URL;
	}

	public static void printQuitMsg() {

		System.out.println();
		System.out.print("Thank You for Using and Have a good day :) ");

	}

	public static void printWelcome() {
		System.out.println("Welcome to Currency converter App");
	}

	public static void printMenu() {

		System.out.println("\nOptions:");
		System.out.println("1. Add favorite currency");
		System.out.println("2. View favorite currencies");
		System.out.println("3. Update favorite currency");
		System.out.println("4. Convert currency from favorite currencies");
		System.out.println("5. Convert currency");
		System.out.println("6. Exit");
		System.out.print("Choice : ");

	}

}
