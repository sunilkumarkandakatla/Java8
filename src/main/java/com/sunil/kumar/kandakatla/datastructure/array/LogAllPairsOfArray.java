package com.sunil.kumar.kandakatla.datastructure.array;

public class LogAllPairsOfArray {

	private static void logAllPairsOfArray(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println("[" + arr[i] + "," + arr[j] + "]");
			}
		}
	}

	public static void main(String[] args) {
		// Log all pairs of array

		char[] arr = { 'a', 'b', 'c', 'd', 'e' };

		logAllPairsOfArray(arr);
	}

}
