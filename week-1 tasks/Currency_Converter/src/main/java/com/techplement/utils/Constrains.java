package com.techplement.utils;

public enum Constrains {

	API_KEY("12232bce87269c4a03cc7f66");

	private String resources;

	Constrains(String resources) {
		this.resources = resources;
	}

	public String getResource() {

		return resources;
	}
}
