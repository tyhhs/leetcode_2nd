package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tyh.util.ListTools;

public class Subsets_II {

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		List<List<Integer>> lists = new Subsets_II().subsetsWithDup(nums);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        set.add(list);
        helper(set, new ArrayList<Integer>(), 0, nums);
        return new ArrayList<List<Integer>>(set);
    }
    public void helper(Set<List<Integer>> set, List<Integer> list, int index, int[] nums){
    	for(int i = index; i < nums.length; i++){
    		list.add(nums[i]);
    		List<Integer> addItem = new ArrayList<Integer>(list);
    		set.add(addItem);
    		helper(set, list, i+1, nums);
    		list.remove(list.size()-1);
    	}
    }
}
