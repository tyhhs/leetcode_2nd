package com.tyh.code;

public class Search_in_Rotated_Sorted_Array_II {

	public static void main(String[] args) {
		int[] nums = {1,3,1,1,1};
		System.out.println(new Search_in_Rotated_Sorted_Array_II().search(nums, 3));
	}

    public boolean search(int[] nums, int target) {
        int length = nums.length;
    	int left = 0;
        int right = length - 1;
        while(left <= right){
        	int mid = left + (right - left) / 2;
        	if(nums[mid] == target){
        		return true;
        	}
        	else if(nums[left] < nums[mid]){//the first part is well sorted
        		if(target < nums[mid] && target >= nums[left]){//target in second part
        			right = mid - 1;
        		}
        		else{
        			left = mid + 1;
        		}
        	}
        	else if(nums[left] > nums[mid]){//the second part is well sorted
        		if(target > nums[mid] && target <= nums[right]){//target in second part
        			left = mid + 1;
        		}
        		else{
        			right = mid - 1;
        		}
        	}
        	else{// nums[left] == nums[mid]
        		left++;
        	}
        }
        return false;
    }
}
