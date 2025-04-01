package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHandler {
	
	static Properties config = new Properties();
	public static String s = System.getProperty("file.separator");
	public static String userDir = System.getProperty("user.dir");
	public static String filePath = userDir + s + "src" + s + "test" + s + "resources" + s;
	public static String xlPath = filePath + "excel" + s + "booksTestLoginData.xlsx";
	public static String configPath = filePath + "config.properties";
	
	public static String getProperty(String key) {
		String result = "";
		try {
			FileInputStream input = new FileInputStream(configPath);
			config.load(input);
			result = config.getProperty(key);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}

}
