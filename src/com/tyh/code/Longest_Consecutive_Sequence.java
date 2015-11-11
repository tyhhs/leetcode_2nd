package com.tyh.code;

import java.util.Arrays;
import java.util.HashMap;

public class Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		int[] nums = {1,2,0,1};
		System.out.println(new Longest_Consecutive_Sequence().longestConsecutive2(nums));
	}

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
    	Arrays.sort(nums);
        int res = 1;
        int localLen = 1;
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] == nums[i-1]+1) {
        		localLen++;
        	}		
        	else if(nums[i] == nums[i-1]){
        		continue;
        	} 		
        	else{
        		res = Math.max(localLen, res);
        		localLen = 1;
        	}
        }
        res = Math.max(localLen, res);
        return res;
    }
    
    public int longestConsecutive2(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);
                // keep track of the max length 
                res = Math.max(res, sum);
                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
