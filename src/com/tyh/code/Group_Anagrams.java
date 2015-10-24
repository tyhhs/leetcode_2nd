package com.tyh.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tyh.util.ListTools;

public class Group_Anagrams {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = new Group_Anagrams().groupAnagrams(strs);
		ListTools.printStringListInList(lists);
	}

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for(String s : strs){
        	char[] charArray = s.toCharArray();
        	Arrays.sort(charArray);
        	String key = new String(charArray);
        	if(map.containsKey(key)){
        		List<String> list = map.get(key);
        		list.add(s);
        		map.put(key,list);
        	}
        	else{
        		List<String> list = new ArrayList<String>();
        		list.add(s);
        		map.put(key, list);
        	}
        }
        for(String key : map.keySet()){
        	lists.add(map.get(key));
        }
        return lists;
    }
}
