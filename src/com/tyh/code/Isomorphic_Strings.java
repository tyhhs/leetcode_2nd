package com.tyh.code;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ac";
		String t = "ba";
		System.out.println(new Isomorphic_Strings().isIsomorphic(s, t));
	}
	
	//map without using hashmap
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[512];
        for(int i = 0; i < s.length(); i++){
            if(map[s.charAt(i)] != map[t.charAt(i) + 256]) return false;
            map[s.charAt(i)] = map[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
    
    public boolean isIsomorphic1(String s, String t) {
        if(s == null || s.length() == 0) return true;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        //map is used to map the mapping relationship of chars between two strings
        Map<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < sChars.length; i++){
            Character sChar = sChars[i];
            Character tChar = tChars[i];
            if(map.containsKey(sChar)){
                if(map.get(sChar) != tChar){
                	return false;
                }
            }
            else if(map.containsValue(tChar)){
            	return false;
            }
            else{
            	map.put(sChar, tChar);
            }
        }
        return true;
    }
}
