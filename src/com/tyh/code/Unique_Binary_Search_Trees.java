package com.tyh.code;

public class Unique_Binary_Search_Trees {

	public static void main(String[] args) {
		System.out.println(new Unique_Binary_Search_Trees().numTrees(19));
	}

	//dynamic programming
	public int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++){
			int res = 0;
			for(int j = 1; j <= i; j++){
				int left = dp[j-1];
				int right = dp[i-j];
				res += (left * right);
			}
			dp[i] = res;
		}
		return dp[n];
	}
	//recursive implementation, time limited exceeded
    public int numTrees2(int n) {
    	if(n == 0 || n == 1){
    		return 1;
    	}
    	int res = 0;
    	for(int i = 1; i <= n; i++){
    		int left = numTrees(i-1);
    		int right = numTrees(n-i);
    		res += (left * right);
    	}
    	return res;
    }
}
