package com.tyh.code;

import java.util.Arrays;

public class Majority_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,1,4,1,5,1};
		System.out.println(new Majority_Element().majorityElement(nums));
	}
	//O(n) solution
	public int majorityElement(int[] nums){
		int major = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length; i++){
			if(count == 0){
				major = nums[i];
				count++;
			}
			else if(major == nums[i]){
				count++;
			}
			else{
				count--;
			}
		}
		return major;
	}
	public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	
}
