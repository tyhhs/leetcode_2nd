package com.tyh.code;

public class Longest_Common_Prefix {
	public static void main(String[] args) {
		String[] strs = {"abcdefgh","abcdef","abcdefg"};
		//String[] strs = {"b","a"};
		String res = new Longest_Common_Prefix().longestCommonPrefix(strs);
		System.out.println(res);
	}
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}
		String pre = strs[0];
		int i = 1;
		while(i < strs.length){
			while(strs[i].indexOf(pre) != 0){
				pre = pre.substring(0, pre.length()-1);
			}
			i++;
		}
		return pre;
	}
    public String longestCommonPrefix2(String[] strs) {
    	String res = "";
    	if(strs.length == 0){
    		return res;
    	}
    	int index = 0;
    	char currentChar;
    	while(index < strs[0].length()){
			currentChar = strs[0].charAt(index);

    		for(String str : strs){
    			if(index < str.length()){
    				if(str.charAt(index) != currentChar){
        				res = str.substring(0, index);
        				return res;
        			}
    			}
    			else{
    				res = str.substring(0);
    				return res;
    			}
    			
    		}
    		index ++;
    	}
    	return strs[0];
    }
}
