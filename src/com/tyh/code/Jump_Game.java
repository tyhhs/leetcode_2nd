package com.tyh.code;

public class Jump_Game {

	public static void main(String[] args) {
		int[] nums = {3, 2, 3, 0, 4, 0, 0};
		System.out.println(new Jump_Game().canJump(nums));
	}

    public boolean canJump(int[] nums) {
    	if(nums.length == 0){
    		return false;
    	}
    	int cur = 0;
    	int farthest = cur;
    	while(cur < nums.length - 1 && farthest <= nums.length - 1){
    		if(nums[cur] == 0){
    			return false;
    		}
    		int next = 0;
    		for(int i = cur + 1; i <= cur + nums[cur]; i++){
    			
        		if(i + nums[i] >= farthest){
        			next = i;
        			farthest = i + nums[i];
        		}
        	}
    		cur = next;
    	}
    	return true;
    }
}
