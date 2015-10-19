package com.tyh.code;

public class Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		int[] nums = {3, 1};
		System.out.println(new Search_in_Rotated_Sorted_Array().search(nums, 1));
	}

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
			return -1;
		}
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
        	int mid = low + (high - low)/2;
        	if (nums[mid] == target) {
				return mid;
			}
        	else if (nums[low] <= nums[mid]) {
				if (target >= nums[low] && target <= nums[mid]) {
					high = mid - 1;
				}
				else{
					low = low + 1;
				}
			}
        	else{//nums[low] > nums[mid], the rotated point is in the first part and the second part is well sorted
        		if (target >= nums[mid] && target <= nums[high]) {
					low = mid + 1;
				}
        		else{
        			high = mid - 1;
        		}
        	}
        }
        return -1;
    }
}
