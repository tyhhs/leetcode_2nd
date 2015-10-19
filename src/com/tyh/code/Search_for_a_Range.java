package com.tyh.code;

public class Search_for_a_Range {

	public static void main(String[] args) {
		int nums[] = {5, 7, 7, 8, 8, 10};
		int[] res = new Search_for_a_Range().searchRange(nums, 8);
		for(int i : res){
			System.out.println(i);
		}

	}

    public int[] searchRange(int[] nums, int target) {
        //the first index
    	int first = firstGreaterOrEqual(nums, target);
    	//if the index == length or the first one is greater than the target, that means we didn't found the target in the array
    	if (first == nums.length || nums[first] != target) {
			return new int[]{-1, -1};
		}
    	int second = firstGreaterOrEqual(nums, target + 1)-1;
    	return new int[]{first,second};
    }
    //give an array of sorted array and a target number, return the index of the first number which is greater of equal to the target
    public int firstGreaterOrEqual(int[] nums, int target){
    	int low = 0;
    	int high = nums.length;
    	while(low < high){
    		int mid = low + (high - low)/2;
    		if(nums[mid] < target){
    			low = mid + 1;
    		}
    		else{
    			high = mid;
    		}
    	}
    	return low;
    }
}
