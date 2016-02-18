package com.tyh.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Repeated_DNA_Sequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AAAAAAAAAAA";
		List<String> list = new Repeated_DNA_Sequences().findRepeatedDnaSequences(s);
		for(String sub : list){
			System.out.println(sub);
		}
	}
	//hashmap and bit manipulation, memory saving
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() <10) return new ArrayList<String>();
        int len = s.length();
        //set is used to store all combination of 10 letters
        Set<Integer> set = new HashSet<Integer>();
        //res is used to store all substrings that occur more than twice, no duplicate
        Set<Integer> res = new HashSet<Integer>();
        //subs is the return result
        List<String> subs = new ArrayList<String>();
        //map is used to map letter to integer
        char[] map = new char[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        int curString = 0;
        int curChar = 0;
        //build the first String
        //store the letters in reverse order, to make window delete and add easier
        for(int i = 0; i < 10; i++){
            curChar = map[s.charAt(i) - 'A'];
            curString += (curChar << (2 * i));
        }
        //add the first subString into the set
        set.add(curString);
        //handle all possible letter combinations
        for(int i = 1; i <= len - 10; i++){
            //delete the first letter
            curString = curString >> 2;
            //add the new letter
            curChar = map[s.charAt(i + 9) - 'A'];
            curString += curChar << 18;
            //check the set
            //set contains the string and it's the first time to add to the res set
            if(!set.add(curString) && res.add(curString)){
                subs.add(s.substring(i, i + 10));
            }
        }
        return subs;
    }
    
    //just store the substrings in the set, take much more space than method 1
    public List<String> findRepeatedDnaSequences2(String s) {
        if(s == null || s.length() < 10) return new ArrayList<String>();
        Set<String> res = new HashSet<String>();
        int len = s.length();
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < len - 9; i++){
            String sub = s.substring(i, i + 10);
            if(set.contains(sub)){
                res.add(sub);
            }
            else{
                set.add(sub);
            }
        }
        return new ArrayList<String>(res);
    }
}
