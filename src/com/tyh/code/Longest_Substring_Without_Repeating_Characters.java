package com.tyh.code;

public class Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(new Longest_Substring_Without_Repeating_Characters().
				lengthOfLongestSubstring(s));
	}
	/*the variable 'begin' keeps the index of the beginning of the subarray
	 * array index[ch] keep the index of this ch last time appeared
	 * max is the length of the longest subarray without repeating  
	 * */
    public int lengthOfLongestSubstring(String s) {
        //special case
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	
    	//array to store index of character last time appeared(one based)
    	int[] index = new int[256];
    	int max = 0;
    	int begin = 0;
    	for(int i = 0; i < s.length(); i++){
    		char ch = s.charAt(i);
    		if(index[ch] > begin){
    			begin = index[ch];
    		}
    		index[ch] = i + 1;
    		max = Math.max(max, i - begin + 1);
    	}
    	return max;
    }
}
