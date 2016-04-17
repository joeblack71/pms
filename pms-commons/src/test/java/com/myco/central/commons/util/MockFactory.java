package com.myco.central.commons.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MockFactory {
	private static final String BUNDLE_NAME = "com.myco.central.util.fixture";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private MockFactory() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
