package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.tyh.util.ListTools;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> lists = new Permutations().permute(nums);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        lists.add(first);
        for(int i = 1; i < nums.length; i++){
        	List<List<Integer>> tempLists = new ArrayList<List<Integer>>();
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
    	return lists;
    }
}
