package com.tyh.code;

public class Maximum_Product_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4, -3, -2};
		System.out.println(new Maximum_Product_Subarray().maxProduct(nums));
	}

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int maxBefore = nums[0];
        int minBefore = nums[0];
        int max = nums[0];
        int maxHere, minHere;
        for(int i = 1; i < nums.length; i++){
            maxHere = Math.max(Math.max(maxBefore * nums[i], minBefore * nums[i]), nums[i]);
            minHere = Math.min(Math.min(maxBefore * nums[i], minBefore * nums[i]), nums[i]);
            max = Math.max(maxHere, max);
            maxBefore = maxHere;
            minBefore = minHere;
        }
        return max;
    }	
}
