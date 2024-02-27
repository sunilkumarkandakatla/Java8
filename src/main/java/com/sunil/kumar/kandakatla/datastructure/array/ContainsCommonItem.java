package com.sunil.kumar.kandakatla.datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsCommonItem {

	private static boolean containsCommonItem1(String[] arr1, String[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			String string1 = arr1[i];
			for (int j = 0; j < arr2.length; j++) {
				String string2 = arr2[j];
				if (string1.equals(string2)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean containsCommonItem2(String[] arr1, String[] arr2) {
		Map<String, Boolean> map = new HashMap<>();
		for (int j = 0; j < arr2.length; j++) {
			String string2 = arr2[j];
			map.put(string2, true);
		}

		for (int i = 0; i < arr1.length; i++) {
			String string1 = arr1[i];
			if (map.get(string1)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] arr1 = { "a", "b", "c", "x" };
		String[] arr2 = new String[] { "z", "y", "a" };

		System.out.println(containsCommonItem1(arr1, arr2));
		System.out.println(containsCommonItem2(arr1, arr2));
	}

}
