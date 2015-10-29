package com.tyh.code;

import com.tyh.util.ArrayTools;

public class Sort_Colors {

	public static void main(String[] args) {
		int[] nums = {1,2,0,2,1,2,1,2,0,0,1,2,2,1};
		new Sort_Colors().sortColors2(nums);
		ArrayTools.printIntArray(nums);
	}

	//straight forward solution
    public void sortColors(int[] nums) {
    	int countZeros = 0;
    	int countOnes = 0;
    	for(int i : nums){
    		if(i == 0) countZeros++;
    		if(i == 1) countOnes++;
    	}
    	int i = 0;
    	while(i < countZeros){
    		nums[i] = 0;
    		i++;
    	}
    	while(i < countZeros + countOnes){
    		nums[i]	= 1;
    		i++;
    	}
    	while(i < nums.length){
    		nums[i] = 2;
    		i++;
    	}
    }
    
    //one pass solution
    public void sortColors2(int[] nums) {
    	int zero = 0;
    	int two = nums.length - 1;
    	int cur = 0;
    	while(cur <= two){
    		if(nums[cur] == 0){//swap numbers at zero and cur, if zero is not equal to cur
    			if(zero != cur){
    				nums[zero] = 0;
    				nums[cur] = 1;
    			}
    			zero++;
    			cur++;
    		}
    		else if(nums[cur] == 2){//swap cur and two, than only minus two
    			int temp = nums[two];
    			nums[two] = nums[cur];
    			nums[cur] = temp;
    			two--;
    		}
    		else{
    			cur++;
    		}
    	}
    }
}
