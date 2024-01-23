package com.sunil.kumar.kandakatla.array;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * 
 * Example 1: 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] 
 * Output: 6 
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * Example 2: Input: nums = [1] 
 * Output: 1 
 * Explanation: The subarray [1] has the largest sum 1.
 * 
 * Example 3: 
 * Input: nums = [5,4,-1,7,8] 
 * Output: 23 
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 **/
public class MaximumSubarray {

	private static int maxSubArray1(int[] nums) {
		int size = nums.length;
		int ans = nums[0];

		int[] temp = new int[size];
		temp[0] = nums[0];

		for (int i = 1; i < size; i++) {
			temp[i] = Math.max(nums[i], nums[i] + temp[i - 1]);
			ans = Math.max(ans, temp[i]);
		}
		System.out.println("ans -> " + ans);
		return ans;
	}

	private static int maxSubArray2(int[] nums) {
		int size = nums.length;
		int currentSum = 0;
		int maxSum = nums[0];

		for (int i = 0; i < size; i++) {
			currentSum += nums[i];

			if (maxSum < currentSum) {
				maxSum = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		System.out.println("ans -> " + maxSum);
		return maxSum;
	}

	private static int maxSubArray3(int[] nums) {
		int size = nums.length;
		int currentSum = 0;
		int maxSum = nums[0];

		int start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			currentSum += nums[i];

			if (maxSum < currentSum) {
				maxSum = currentSum;
				start = s;
				end = i;
			}

			if (currentSum < 0) {
				currentSum = 0;
				s = i + 1;
			}
		}
		System.out.println("start -> " + start);
		System.out.println("end -> " + end);
		System.out.println("ans -> " + maxSum);
		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
		maxSubArray1(nums);

		maxSubArray2(nums);

		maxSubArray3(new int[]{5,4,-1,7,8});
	}

}
