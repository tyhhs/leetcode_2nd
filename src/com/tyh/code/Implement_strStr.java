package com.tyh.code;

public class Implement_strStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int strStr(String haystack, String needle) {
    	int nLength = needle.length();
    	int hLength = haystack.length();
    	if(hLength < nLength){
    		return -1;
    	}
    	for(int i = 0; i <= hLength - nLength; i++){
    		if (haystack.substring(i, i+nLength).equals(needle)) {
				return i;
			}
    	}
    	return -1;
    }
    
}
