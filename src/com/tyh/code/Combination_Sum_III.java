package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.util.ListTools;

public class Combination_Sum_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new Combination_Sum_III().combinationSum3(3, 9);
		ListTools.printListInList(res);
	}

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int low, int k, int target){
        if(list.size() == k && target == 0){
        	res.add(new ArrayList<Integer>(list));
        	return;
        }
        for(int i = low; i <= (target < 9 ? target : 9); i++){
            list.add(i);
            helper(res, list, i + 1, k, target - i);
            list.remove(list.size() - 1);
        }
    }
}
