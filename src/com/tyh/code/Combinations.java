package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.util.ListTools;

public class Combinations {

	public static void main(String[] args) {
		List<List<Integer>> lists = new Combinations().combine(4, 2);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	helper(n, k, 1, lists, new ArrayList<Integer>());
    	return lists;
    }
    
    public void helper(int n, int k, int start, List<List<Integer>>	lists, List<Integer> list){
    	if(list.size() == k){
    		List<Integer> item = new ArrayList<Integer>(list);
    		lists.add(item);
    		return;
    	}
    	for(int i = start; i <= n; i++){
    		list.add(i);
    		helper(n, k, i + 1, lists, list);
    		list.remove(list.size() - 1);
    	}
    }
}
