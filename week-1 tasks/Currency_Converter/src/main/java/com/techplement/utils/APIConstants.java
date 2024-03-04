package com.techplement.utils;

public enum APIConstants {

	API_KEY("12232bce87269c4a03cc7f66");

	private String resources;

	APIConstants(String resources) {
		this.resources = resources;
	}

	public String getValue() {
		return resources;
	}
}
