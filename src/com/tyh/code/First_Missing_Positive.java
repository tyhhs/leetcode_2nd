package com.tyh.code;

public class First_Missing_Positive {

	public static void main(String[] args) {
		int[] nums = {1,1};
		System.out.println(new First_Missing_Positive().firstMissingPositive(nums));

	}

	  public int firstMissingPositive(int[] nums) {
	        int i = 0;
	        while(i<nums.length){
	        	if(nums[i]==i+1||nums[i]<=0||nums[i]>nums.length){
	        		i++;
	        	}
	        	else if(nums[nums[i]-1]!=nums[i]){
		       		int temp=nums[i];
		        	nums[i]=nums[nums[i]-1];   
		        	nums[temp-1]=temp;
		        }
	        	else {
					i++;
				}
	        }
	        for(i=0; i<nums.length;i++){
	        	if(nums[i]!=i+1){
	        		return i+1;
	        	}
	        }
	        return i+1;
	    }
}
