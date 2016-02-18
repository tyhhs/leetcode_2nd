package com.tyh.code;

import java.util.Arrays;
import java.util.Comparator;

public class Largest_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(new Largest_Number().largestNumber(nums));
	}

	public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        int len = nums.length;
        String numsString[] = new String[len];
        for(int i = 0; i < len; i++){
        	numsString[i] = "" + nums[i];
        }
        Comparator<String> comp = new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return (s2 + s1).compareTo(s1 + s2);
			}
        };
        Arrays.sort(numsString,comp);
        if(numsString[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : numsString){
        	sb.append(s);
        }
        return sb.toString();
    }
}
