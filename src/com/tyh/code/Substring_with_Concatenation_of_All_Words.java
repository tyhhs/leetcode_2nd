package com.tyh.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tyh.util.ListTools;

public class Substring_with_Concatenation_of_All_Words {

	public static void main(String[] args) {
		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words = {"fooo","barr","wing","ding","wing"};
		List list = new Substring_with_Concatenation_of_All_Words().findSubstring(s, words);
		ListTools.printList(list);
	}

	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0 || S.length() < L.length * L[0].length())   return res;
        int N = S.length(), M = L.length, K = L[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String s : L) {
            if (map.containsKey(s))   map.put(s, map.get(s) + 1);
            else                      map.put(s, 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < K; i++) {
            int count = 0;  // remark: reset count 
            for (int l = i, r = i; r + K <= N; r += K) {
                str = S.substring(r, r + K);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))   curMap.put(str, curMap.get(str) + 1);
                    else                           curMap.put(str, 1);

                    if (curMap.get(str) <= map.get(str))    count++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = S.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += K;
                        if (curMap.get(tmp) < map.get(tmp)) count--;
                    }
                    if (count == M) {
                        res.add(l);
                        tmp = S.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += K;
                        count--;
                    }
                }else {
                    curMap.clear();
                    count = 0;
                    l = r + K;
                }
            }
            curMap.clear();
        }
        return res;
    }
	
	/*public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		int sLen = s.length();
		if (words.length == 0 || sLen < words.length*words[0].length()) {
			return list;
		}
		int wordLen = words[0].length();
		int length = words.length*wordLen;
		//build a words dictionary
		Map<String, Integer> map = new HashMap<>();
		for(String word : words){
			if (map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			}
			else {
				map.put(word, 1);
			}
		}
		int i = 0;
		while(i <= sLen - length){
			HashMap<String, Integer> curMap = new HashMap<>();
			for(int j = i; j <= i + length - wordLen; j += wordLen){
				String subTemp = s.substring(j, j + wordLen);
				if(map.containsKey(subTemp)){
					if (curMap.containsKey(subTemp)) {
						if (curMap.get(subTemp) < map.get(subTemp)) {
							curMap.put(subTemp, curMap.get(subTemp)+1);
						}
						else {
							i ++;
							break;
						}
					}
					else{
						curMap.put(subTemp, 1);
					}
				}
				else{
					i = ++j;
					break;
				}
			}
			if(curMap.equals(map)){				
				list.add(i);
				i++;
			}
		}
		return list;
	}*/
/*    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
    	int length = 0;
    	int wordLen = words[0].length();
        for(String word : words){
        	length += word.length();
        }
        for(int i = 0; i <= s.length() - length; i += wordLen){
        	String temp = s.substring(i, i+length);
        	Set<Integer> set = new HashSet<Integer>();
        	for(String word : words){
        		int index;
        		if ((index = temp.indexOf(word)) != -1) {
					for(int j = index; j < index + word.length(); j++){
						if(!set.add(j)){
							break;
						}
					}
				}
        		else{
        			break;
        		}
        	}
        	if(set.size() == length){
        		list.add(i);
        	}        	
        }
        return list;
    }*/
}
