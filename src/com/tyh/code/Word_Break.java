package com.tyh.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Word_Break {

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>(Arrays.asList("leet", "code"));
		System.out.println(new Word_Break().wordBreak(s, wordDict));
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s.length() == 0) return true;
		if(wordDict.isEmpty()) return false;
		boolean[] breaks = new boolean[s.length() + 1];
		breaks[0] = true;
		for(int i = 1; i < s.length()+1; i++){
			for(int j = 0; j < i; j++){
				if(breaks[j] && wordDict.contains(s.substring(j,i))){
					breaks[i] = true;
					break;
				}
			}
		}
		return breaks[s.length()];
	}
}
