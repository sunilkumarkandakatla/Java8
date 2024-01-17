package com.sunil.kumar.kandakatla.array;

import java.util.Arrays;

public class MergeSortedArrays {

	private static Integer[] mergeSortedArrays1(Integer[] foo, Integer[] bar) {
		if (null == foo || foo.length == 0) {
			return bar;
		} else if (null == bar || bar.length == 0) {
			return foo;
		}

		int fooLength = foo.length;
		int barLength = bar.length;

		Integer[] merge = new Integer[fooLength + barLength];

		int fooPostition = 0;
		int barPostition = 0;
		int mergePostition = 0;

		while (fooPostition < fooLength && barPostition < barLength) {
			if (foo[fooPostition] < bar[barPostition]) {
				merge[mergePostition++] = foo[fooPostition++];
			} else {
				merge[mergePostition++] = bar[barPostition++];
			}
		}

		while (fooPostition < fooLength) {
			merge[mergePostition++] = foo[fooPostition++];
		}

		while (barPostition < barLength) {
			merge[mergePostition++] = bar[barPostition++];
		}

		return merge;
	}

	public static void main(String[] args) {
		Integer[] mergeSortedArray1 = mergeSortedArrays1(new Integer[] { 0, 3, 4, 31 }, new Integer[] { 3, 4, 6, 30 });
		System.out.println(Arrays.toString(mergeSortedArray1));
	}

}
