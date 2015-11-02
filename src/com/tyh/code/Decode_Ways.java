package com.tyh.code;

public class Decode_Ways {

	public static void main(String[] args) {
		String s = "";
		System.out.println(new Decode_Ways().numDecodings(s));
	}

    public int numDecodings(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	int length = s.length();
        int[] dp = new int[length+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i < length; i++){
        	dp[i+1] = (s.charAt(i) == '0'?0:dp[i]) + (isTwoCharACode(s, i)?dp[i-1]:0);
        }
        return dp[length];
    }
    
    public boolean isTwoCharACode(String s, int index){
    	if(s.charAt(index-1) == '0') return false;
    	int num = (s.charAt(index-1) - '0') * 10 + s.charAt(index) - '0';
    	if(num > 0 && num <= 26){
    		return true;
    	}
    	return false;
    }
}
