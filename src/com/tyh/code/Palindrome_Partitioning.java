package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.util.ListTools;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		String s = "";
		List<List<String>> lists = new Palindrome_Partitioning().partition(s);
		ListTools.printStringListInList(lists);
	}

    public List<List<String>> partition(String s) {
    	List<List<String>> lists = new ArrayList<List<String>>();
    	helper(lists, new ArrayList<String>(), s);
    	return lists;
    }
    private void helper(List<List<String>> lists, List<String> list, String s){
    	if(s.length() == 0){
    		lists.add(list);
    	}
    	for(int i = 1; i <= s.length(); i++){
    		String s1 = s.substring(0, i);
    		if(isPalindrome(s1)){
    			List<String> newList = new ArrayList<String>(list);
    			newList.add(s1);
    			String s2 = s.substring(i);
    			helper(lists, newList, s2);
    		}
    	}
    }
    private boolean isPalindrome(String s){
    	for(int i = 0; i < s.length()/2; i++){
    		if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
    	}
    	return true;
    }
}
