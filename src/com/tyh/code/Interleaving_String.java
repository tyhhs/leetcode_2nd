package com.tyh.code;

public class Interleaving_String {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(new Interleaving_String().isInterleave(s1, s2, s3));
	}

	//dynamic programming
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
    	if(len1 + len2 != len3){
    		return false;
    	}
    	boolean[][] dp = new boolean[len1+1][len2+1];
    	dp[0][0] = true;
    	for(int i = 1; i <= len1; i++){
    		if(s3.charAt(i-1) == s1.charAt(i-1)){
    			dp[i][0] = true;
    		}
    		else{
    			break;
    		}
    	}
    	for(int i = 1; i <= len2; i++){
    		if(s3.charAt(i-1) == s2.charAt(i-1)){
    			dp[0][i] = true;
    		}
    		else{
    			break;
    		}
    	}
    	for(int i = 1; i <= len1; i++){
    		for(int j = 1; j <= len2; j++){
    			if((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))||
    					(dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))){
    				dp[i][j] = true;
    			}
    		}
    	}
    	return dp[len1][len2];
    }
}
