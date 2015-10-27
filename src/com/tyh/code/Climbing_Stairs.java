package com.tyh.code;

public class Climbing_Stairs {

	public static void main(String[] args) {
		System.out.println(new Climbing_Stairs().climbStairs(44));
	}

    public int climbStairs(int n) {
    	if(n == 1 || n == 0){
    		return 1;
    	}
    	int[] steps = new int[n+1];
    	steps[0] = 1;
    	steps[1] = 1;
    	for(int i = 2; i <= n; i++){
    		steps[i] = steps[i-1] + steps[i-2];
    	}
    	return steps[n];
    } 
}
