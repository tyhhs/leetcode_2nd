package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.tyh.util.ListTools;

public class Three_Sum {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = new Three_Sum().threeSum2(nums);
		ListTools.printListInList(res);
	}
	
    public List<List<Integer>> threeSum(int[] nums) {
       	Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }
    
    public List<List<Integer>> threeSum2(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if (nums.length < 3) {
			return res;
		}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-2; i++) {
    		if (i == 0 || nums[i] != nums[i-1]) {
    			int target = 0 - nums[i];
    			int start = i + 1;
    			int end = nums.length - 1;
    			while(start < end){
    				int temp = nums[start] + nums[end];
    				if (temp == target) {
    					res.add(Arrays.asList(nums[i], nums[start], nums[end]));
    					while(start < end && nums[start] == nums[start+1]) start++;
    					while(start < end && nums[end] == nums[end-1]) end--;
    					start++;
    					end--;
    				}
    				else if (temp < target) {
    					start++;
    				}
    				else {
    					end --;
    				}
    			}
			}			
		}
    	return res;
    }
    
}
