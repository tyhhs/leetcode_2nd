package com.tyh.code;

public class Minimum_Size_Subarray_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(new Minimum_Size_Subarray_Sum().minSubArrayLen(11, nums));
	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		while (j < nums.length) {
			sum += nums[j++];
			while (sum >= s) {
				min = Math.min(min, j - i);
				sum -= nums[i++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
