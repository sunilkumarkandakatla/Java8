package com.sunil.kumar.kandakatla.datastructure.array;

import java.util.Arrays;

public class RotateIntegerArray {

	private static void reverse1(int nums[], int start, int end) {
		if (start > end)
			return;
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
		reverse1(nums, start + 1, end - 1);
	}

	private static void rotate1(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		reverse1(nums, 0, n - 1);
		reverse1(nums, 0, k - 1);
		reverse1(nums, k, n - 1);
	}

	private static void reverse2(int nums[], int i, int j) {
		int li = i;
		int ri = j;

		while (li < ri) {
			int temp = nums[li];
			nums[li] = nums[ri];
			nums[ri] = temp;

			li++;
			ri--;
		}
	}

	private static void rotate2(int[] nums, int k) {
		k = k % nums.length;
		if (k < 0) {
			k += nums.length;
		}
		reverse2(nums, 0, nums.length - k - 1);
		reverse2(nums, nums.length - k, nums.length - 1);
		reverse2(nums, 0, nums.length - 1);
	}

	private static void rotate3(int[] nums, int k) {
		int n = nums.length;
		k = k % n; // No. of rotations
		int i, j;

		// Reverse last k numbers
		// 4 - 6,
		for (i = n - k, j = n - 1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		System.out.println(Arrays.toString(nums));

		// 0 - 3, 1 - 2
		// Reverse the first n-k terms
		for (i = 0, j = n - k - 1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		System.out.println(Arrays.toString(nums));

		// 0 - 6, 1 - 5, 2 - 4, 
		// Reverse the entire array
		for (i = 0, j = n - 1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
		int rotation1 = 3;
		
		rotate1(nums1, rotation1);
		System.out.println(Arrays.toString(nums1));

		int[] nums2 = { 1, 2, 3, 4, 5, 6, 7 };
		int rotation2 = 3;
		
		rotate2(nums2, rotation2);
		System.out.println(Arrays.toString(nums2));

		int[] nums3 = { 1, 2, 3, 4, 5, 6, 7 };
		int rotation3 = 3;
		
		rotate3(nums3, rotation3);
		System.out.println(Arrays.toString(nums3));

	}

}
