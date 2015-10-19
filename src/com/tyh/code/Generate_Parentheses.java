package com.tyh.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tyh.util.ListTools;

public class Generate_Parentheses {

	public static void main(String[] args) {
		List<String> list = new Generate_Parentheses().generateParenthesis(3);
		ListTools.printStringList(list);
	}

    public List<String> generateParenthesis(int n) {
    	List<List<String>> lists = new ArrayList<List<String>>();
    	lists.add(Collections.singletonList(""));
    	for(int i = 1; i <= n; i++){
    		List<String> list = new ArrayList<String>();
    		for(int j = 0; j < i; j++){
    			List<String> first = lists.get(j);
    			List<String> second = lists.get(i-j-1);
    			for(String firstString:first){
    				for(String secondString:second){
    					StringBuilder sb = new StringBuilder();
    					sb.append("(").append(firstString).append(")").append(secondString);
    					list.add(sb.toString());
    				}
    			}
    		}
    		lists.add(list);
    	}
    	return lists.get(n);
    }
}
