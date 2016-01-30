package com.tyh.code;

public class Find_Minimum_in_Rotated_Sorted_Array_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,4,4,4,4,4,4,5,6,7,0,1,2,3,4,4,4,4,4,4,4,4,4,4,4,4,4};
		System.out.println(new Find_Minimum_in_Rotated_Sorted_Array_II().findMin(nums));
	}

	public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){//the min is in the left part
                left = mid + 1;
            }
            else if(nums[right] > nums[mid]){//the min is in the right part
                right = mid;
            }
            else{//move the right boundary
                right--;
            }
        }
        return nums[left];
    }
}
