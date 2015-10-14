package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tyh.util.ListTools;

public class Four_Sum {

	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> list = new Four_Sum().fourSum(nums, target);
		ListTools.printListInList(list);
	}

    public List<List<Integer>> fourSum(int[] nums, int target) {
    	if(nums.length<4){
    		return new ArrayList<>();
    	}
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length - 3; i++){
    		for(int j = i + 1; j < nums.length - 2; j++){
    			int tempTarget = target - nums[i] - nums[j];
    			int low = j + 1;
    			int high = nums.length - 1;
    			while(low < high){
    				int temp = nums[low] + nums[high];
    				if (temp < tempTarget) {
						low++;
					}
    				else if (temp > tempTarget) {
						high--;
					}
    				else {
						List<Integer> item = new ArrayList<Integer>();
						item.addAll(Arrays.asList(new Integer[]{nums[i],nums[j],nums[low],nums[high]}));
						set.add(item);
						low++;
						high--;
					}
    			}
    		}
    	}
    	return new ArrayList<List<Integer>>(set);
    }
}
