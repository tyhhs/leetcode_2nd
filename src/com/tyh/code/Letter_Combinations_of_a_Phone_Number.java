package com.tyh.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.tyh.util.ListTools;

public class Letter_Combinations_of_a_Phone_Number {

	public static void main(String[] args) {
		String digits = "23";
		List<String> list = new Letter_Combinations_of_a_Phone_Number().letterCombinations(digits);
		ListTools.printStringList(list);
	}

	public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        LinkedList<String> res = new LinkedList<String>();
        res.offer("");
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] chars = digits.toCharArray();
        for(int i = 0; i < chars.length; i++){
        	int num = chars[i] - '0';
            while(res.peek().length() == i){
                String pre = res.pop();
                for(char c : map[num].toCharArray()){
                    res.offer(pre + c);
                }
            }
        }
        return res;
    }
	
    public List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits.length()==0) {
			return list;
		}
    	String[] phone = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] digit = digits.toCharArray();
        for(char c:digit){
        	int i = c-'0';
        	String addChars = phone[i-2];
        	list = helper(list, addChars);
        }
        return list;
    }
    
    public List<String> helper(List<String> list, String addChars){
    	if (list.isEmpty()) {
			for(char c: addChars.toCharArray()){
				list.add(Character.toString(c));
			}
			return list;
		}
    	else {
			List<String> newList = new ArrayList<String>();
			for(String s : list){
				for(char c : addChars.toCharArray()){
					StringBuilder sb = new StringBuilder();
					sb.append(s).append(c);
					newList.add(sb.toString());
				}
			}
			return newList;
		}
    }
}
