package com.sunil.kumar.kandakatla.array;

public class ReverseAString {

	private static String reverse1(String input) {
		if (input == null || input.isEmpty() || input.length() < 2) {
			return input;
		}

		char[] chars = input.toCharArray();
		char[] resultChars = new char[chars.length];
		int charsLength = chars.length;

		for (int i = 0; i < charsLength; i++) {
			resultChars[charsLength - 1 - i] = chars[i];
		}

		return String.valueOf(resultChars);
	}

	private static String reverse2(String input) {
		if (input == null || input.isEmpty() || input.length() < 2) {
			return input;
		}
		return new StringBuilder(input).reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(reverse1("Timbits Hi"));
		System.out.println(reverse2("Timbits Hi"));
	}

}
