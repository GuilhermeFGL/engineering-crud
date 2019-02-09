package com.guilhermefgl.crudsellerclient.util.validor;

public final class NameValidator {

	private static final int NAME_MIN_LENGTH = 10;
	private static final int NAME_MAX_LENGTH = 50;

	private NameValidator() {
	}

	public static boolean isValid(String name) {
		return name != null && name.length() >= NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH;
	}

}
