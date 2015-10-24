package com.tyh.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tyh.util.ListTools;

public class Permutations_II {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		List<List<Integer>> lists = new Permutations_II().permuteUnique(nums);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> lists = new HashSet<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        lists.add(first);
        for(int i = 1; i < nums.length; i++){
        	Set<List<Integer>> tempLists = new HashSet<List<Integer>>();
        	for(List list : lists){
        		for(int k = 0; k <= list.size(); k++){
        			list.add(k, nums[i]);
        			List<Integer> addItem = new ArrayList<Integer>(list);
        			tempLists.add(addItem);
        			list.remove(k);
        		}
        	}
        	lists = tempLists;
        }
    	return new ArrayList<List<Integer>>(lists);
    }
}
