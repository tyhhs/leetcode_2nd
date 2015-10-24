package com.tyh.code;

public class Maximum_Subarray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new Maximum_Subarray().maxSubArray(nums));
	}

    public int maxSubArray(int[] nums) {
    	if(nums.length == 0){
    		return 0;
    	}
        int max = Integer.MIN_VALUE;
        int pre = 0;
        int localSum = 0;
    	for(int i = 0; i < nums.length; i++){
    		localSum = Math.max(pre + nums[i], nums[i]);
        	max = Math.max(max, localSum);
        	pre = localSum;
        }
    	return max;
    }
}
