package com.tyh.code;

public class Jump_Game_II {

	public static void main(String[] args) {
		int[] nums = {1,2};
		System.out.println(new Jump_Game_II().jump(nums));
	}

    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
        	return 0;
        }
    	int count = 1;
        int next = 0;        
        while(true){
        	if(next + nums[next] >= nums.length - 1){
        		return count;
        	}
        	int farthest = 0;
        	int bound = next + nums[next];
        	for(int i = next + 1; i <= bound; i++){
        		if(i + nums[i] > farthest){
        			farthest = i + nums[i];
        			if(farthest >= nums.length - 1){
        				return ++count;
        			}
        			next = i;
        		}
        	}
        	count++;
        }
    }
}
