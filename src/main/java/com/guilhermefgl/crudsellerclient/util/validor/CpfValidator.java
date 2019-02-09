package com.guilhermefgl.crudsellerclient.util.validor;

public final class CpfValidator {

	private static final String REGEX_ONLY_NUMBERS = "[0-9]+";
	private static final int CPF_LENGHT = 11;

	private CpfValidator() {
	}

	public static boolean isValid(String cpf) {
		return cpf != null && cpf.length() == CPF_LENGHT && cpf.matches(REGEX_ONLY_NUMBERS);
	}

}
