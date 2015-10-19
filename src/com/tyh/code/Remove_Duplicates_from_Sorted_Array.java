package com.tyh.code;

public class Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2};
		System.out.println(new Remove_Duplicates_from_Sorted_Array().removeDuplicates(nums));
	}

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
			return nums.length;
		}
        int count = 1;
    	int pre = nums[0];
    	int curr = 1;
    	int next = 1;
    	while(next < nums.length){
    		while(nums[next] == pre){
    			next++;
    			if (next == nums.length) {
					return count;
				}
    		}
    		pre = nums[next];
    		if(next != curr){
        		nums[curr] ^= nums[next];
        		nums[next] ^= nums[curr];
        		nums[curr] ^= nums[next];
    		}	
    			count++;
    			curr++;
    			next++;
    	}
    	return count;
    }
}
