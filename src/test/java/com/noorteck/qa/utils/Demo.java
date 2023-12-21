package com.noorteck.qa.utils;

import java.io.IOException;

import org.json.JSONException;

public class Demo {
	
	public static void main(String[] args) throws JSONException, IOException {
		DataGenerator obj = new DataGenerator();
		
		obj.gernerateJobData(null, null, "0");
	}

}
