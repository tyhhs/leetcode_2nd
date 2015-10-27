package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence {

	public static void main(String[] args) {
		String res = new Permutation_Sequence().getPermutation(5, 96);
		String res2 = new Permutation_Sequence().getPermutation2(5, 96);
		System.out.println(res);
		System.out.println(res2);
	}

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
        	nums.add(i);
        }
        helper(sb, nums, k);
    	return sb.toString();
    }
    
    public void helper(StringBuilder sb, List<Integer> nums, int k){
    	if(nums.size() == 1){
    		sb.append(nums.get(0));
    	}
    	else{
    		int groupSize = factorial(nums.size() - 1);
    		int group = k / groupSize;
    		int remainder = k % groupSize;
    		if(remainder != 0){
    			sb.append(nums.remove(group));
    			helper(sb, nums, remainder);
    		}
    		else{
    			sb.append(nums.remove(group - 1));
    			helper(sb, nums, groupSize);
    		}
    	}
    }
    
    //contor expansion
    public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
        	nums.add(i);
        }
        helper2(sb, nums, k - 1);
    	return sb.toString();
    }
    
    public void helper2(StringBuilder sb, List<Integer> nums, int k){
    	if(nums.size() == 1){
    		sb.append(nums.get(0));
    	}
    	else{
    		int n = nums.size();
    		int size = factorial(n - 1);
    		int quotient = k / size;
    		int remainder = k % size;
    		sb.append(nums.remove(quotient));
    		helper2(sb, nums, remainder);
    	}
    }
   
    public int factorial(int n){
    	if(n == 1){
    		return 1;
    	}
    	return n * factorial(n -1);
    }
}

