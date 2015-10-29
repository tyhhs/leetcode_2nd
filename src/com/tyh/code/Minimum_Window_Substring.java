package com.tyh.code;

public class Minimum_Window_Substring {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(new Minimum_Window_Substring().minWindow(s, t));
	}

    public String minWindow(String s, String t) {
    	if(s.length()==0||t.length()==0||s.length()<t.length()){
			return "";
		}
		int[] sMap = new int[256];
		int[] tMap = new int[256];
		String res = "";
		int length = Integer.MAX_VALUE;
		int found = 0;
		//store characters in t String into a Map, index represents character, value means number of 
		for(Character c : t.toCharArray()){
			tMap[c]++;
		}
		int start=0, end = 0;
		while(end < s.length()){
			if(found<t.length()){//found a minimum window from start
				if(tMap[s.charAt(end)]!=0){
					sMap[s.charAt(end)]++;
					if(sMap[s.charAt(end)]<=tMap[s.charAt(end)]){
						found++;						
					}
				}
				end++;
			}
			while(found==t.length()){
				if(end-start<length){
					length = end - start;
					res = s.substring(start,end);
				}
				if(tMap[s.charAt(start)]>0){
					sMap[s.charAt(start)]--;
					if(sMap[s.charAt(start)]<tMap[s.charAt(start)]){
						found--;
					}
				}
				start++;
			}
		}
		return res;
    }
}
