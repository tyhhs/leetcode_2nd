package com.tyh.code;

public class Find_Minimum_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(new Find_Minimum_in_Rotated_Sorted_Array().findMin(nums));
	}

	public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int len = nums.length;
        int low = 0;
        int high = len-1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[high]){//in left part
            	high = mid;
            }
            else{
            	low = mid + 1;
            }
        }
        return nums[low];
    }
}
