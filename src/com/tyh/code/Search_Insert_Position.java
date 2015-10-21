package com.tyh.code;

public class Search_Insert_Position {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.out.println(new Search_Insert_Position().searchInsert(nums, 7));
	}

    public int searchInsert(int[] nums, int target) {
    	int length = nums.length;
    	for(int i = 0; i < length; i++){
    		if (target <= nums[i]) {
				return i;
			}
    	}
    	return length;
    }
}
