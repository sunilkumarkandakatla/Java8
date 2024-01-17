package com.sunil.kumar.kandakatla;

import java.util.HashSet;
import java.util.Set;

public class HasPairWithSum {

	private static boolean hasPairWithSum1(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasPairWithSum2(int[] arr, int sum) {
		Set<Integer> numbers = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (numbers.contains(arr[i])) {
				return true;
			}
			numbers.add(sum - arr[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		// [6,4,3,2,1,7], 9
		System.out.println(hasPairWithSum1(new int[]{6,4,3,2,1,7}, 9));
		System.out.println(hasPairWithSum2(new int[]{6,4,3,2,1,7}, 9));
	}

}
