package com.tyh.code;

public class House_Robber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,1,1,6};
		System.out.println(new House_Robber().rob(nums));
	}

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int rob = nums[0];
        int notRob = 0;
        for(int i = 1; i < len; i++){
            int robHere = notRob + nums[i];
            int notRobHere = Math.max(rob, notRob);
            rob = robHere;
            notRob = notRobHere;
        }
        return Math.max(rob, notRob);
    }
}
