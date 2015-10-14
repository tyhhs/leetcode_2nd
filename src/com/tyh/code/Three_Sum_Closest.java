package com.tyh.code;

import java.util.Arrays;

public class Three_Sum_Closest {

	public static void main(String[] args) {
		int[] nums = {1,2,4,8,16,32,64,128};
		System.out.println(new Three_Sum_Closest().threeSumClosest(nums, 82));
	}

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
        	return 0;
        }
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0; i < nums.length-2; i++){
        	int first = nums[i];
        	int low = i + 1;
        	int high = nums.length - 1;        	
        	while(low < high){
        		int tempSum = first + nums[low] + nums[high];
        		if(Math.abs(tempSum - target) < Math.abs(sum - target)){
        			sum = tempSum;
        		}
        		if(tempSum < target){
        			low ++;
        		}
        		else if (tempSum >target) {
					high --;
				}
        		else {
					return target;
				}
        	}
        }
        return sum;        
    }
}
