package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tyh.util.ListTools;

public class Combination_Sum {

	public static void main(String[] args) {
		int candidates[] = {2,3,6,7};
		int target = 7;
		List<List<Integer>> lists = new Combination_Sum().combinationSum(candidates, target);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), set, 0);
        return new ArrayList<List<Integer>>(set);
    }
    
    public void helper(int[] candidates, int target, ArrayList<Integer> list, Set<List<Integer>> set, int start){
    	for(int i = start; i < candidates.length; i++){
    		if(candidates[i] == target){
    			list.add(candidates[i]);
    			set.add(new ArrayList<Integer>(list));
    			list.remove(list.size()-1);
    			return;
    		}
    		else if(candidates[i] > target){
    			return;
    		}
    		else{
    			list.add(candidates[i]);
    			helper(candidates, target - candidates[i], list, set, i);
    			list.remove(list.size()-1);
    		} 		
    	}
    }
}
