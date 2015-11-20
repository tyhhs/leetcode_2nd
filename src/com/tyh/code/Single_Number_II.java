package com.tyh.code;

public class Single_Number_II {

	public static void main(String[] args) {
		int[] nums = {1,2,1,1};
		System.out.println(new Single_Number_II().singleNumber(nums));
	}

    public int singleNumber(int[] nums) {
        int len = nums.length;
    	int[] bits = new int[32];
    	for(int i = 0; i < len; i++){
    		for(int j = 0; j < 32; j++){
    			if(nums[i] == 0) break;
    			bits[j] = (nums[i] & 1) == 1 ? bits[j] +1 : bits[j];
    			nums[i] = nums[i] >> 1;
    		}
    	}
    	int res = 0;
    	for(int i = 0; i < 32; i++){
    		res += bits[i] % 3 == 0 ? 0 : 1 << i;
    	}
    	return res;
    }
}
