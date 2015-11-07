package com.tyh.code;

public class Distinct_Subsequences {

	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(new Distinct_Subsequences().numDistinct(S, T));
	}

	public int numDistinct(String S, String T) {
		int sLen = S.length();
		int tLen = T.length();
		if(sLen < tLen){
			return 0;
		}
		int[][] dp = new int[sLen+1][tLen+1];
		for(int i = 0; i<= sLen; i++){
			dp[i][0] = 1;
		}
		//0 is default value
/*		for(int i = 1; i <= tLen; i++){
			dp[0][i] = 0;
		}*/
		for(int i = 1; i <= sLen; i++){
			for(int j = 1; j <= tLen; j++){
				if(S.charAt(i-1) == T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[sLen][tLen];
	}
}
