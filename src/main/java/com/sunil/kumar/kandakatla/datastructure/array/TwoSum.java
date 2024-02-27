package com.sunil.kumar.kandakatla.datastructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * 
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 */
public class TwoSum {

	private static int[] twoSum1(int[] nums, int target) {
		int size = nums.length;

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (nums[i] + nums[j] == target) {
					System.out.println(Arrays.toString(new int[] { i, j }));
					return new int[] { i, j };
				}
			}
		}

		return new int[] {};
	}

	private static int[] twoSum2(int[] nums, int target) {
		int size = nums.length;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < size; i++) {
			int checkNum = target - nums[i];
			if (null != map.get(checkNum)) {
				int j = map.get(checkNum);
				System.out.println(Arrays.toString(new int[] { j, i }));
				return new int[] { j, i };
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };
		int target = 6;

		twoSum1(nums, target);

		twoSum2(nums, target);
	}

}
