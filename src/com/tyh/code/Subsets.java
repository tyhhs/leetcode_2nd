package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tyh.util.ListTools;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {4,1,0};
		List<List<Integer>> lists = new Subsets().subsets(nums);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> lists = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        lists.add(new ArrayList<Integer>());
        helper(nums, 0, lists, new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(lists);
    }
    
    public void helper(int[] nums, int start, Set<List<Integer>> lists, List<Integer> list){
    	for(int i = start; i < nums.length; i++){
    		list.add(nums[i]);
    		lists.add(new ArrayList<Integer>(list));
    		helper(nums, i+1, lists, list);
    		list.remove(list.size() - 1);
    	}
    }
}
