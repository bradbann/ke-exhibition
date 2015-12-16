package com.kellonge.exhibition.common.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigUtil {

	private static Logger logger = Logger.getLogger(ConfigUtil.class);
	private static Properties properties;

	static {
		load();
	}

	public static void load() {
		try {
			InputStream in = new FileInputStream(getClassPath() + "config.properties");
			properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			logger.warn(e);
		}
	}

	public static String getClassPath() {
		return ConfigUtil.class.getResource("/").getPath().substring(1);
	}

	public static String getProperties(String key) {
		return properties.getProperty(key);
	}

	public static String getRealResourcePath() {
		return getClassPath();
	}

	public static String getRealLangPath(String strLangCode) {
		return getRealResourcePath() + "resource" + "." + strLangCode + ".xml";
	}

	public static void main(String[] args) {
		System.out.println(getClassPath());
		System.out.println(getRealResourcePath());
		System.out.println(getRealLangPath("cn"));
	}

}
